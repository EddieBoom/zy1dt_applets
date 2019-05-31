package com.zy1dt.controller;

import com.zy1dt.entity.WechatConfig;
import com.zy1dt.entity.wx_user;
import com.zy1dt.service.YxcxService;
import com.zy1dt.service.impl.SenseAgroOrderService;
import com.zy1dt.util.DynamicDataSourceHolder;
import com.zy1dt.util.PayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private YxcxService yxcxService;

    @Autowired
    SenseAgroOrderService senseAgroOrderService;

    @RequestMapping(value = "/wxPay", method = RequestMethod.POST)
    public String wxPay(String openId,String orderNumber,HttpServletRequest request) {
        Object result = new Object();
        try {
            //获取自己的openId，
            // 	 String openId = "xxx";
            //订单号，自己的订单设计，最好用固定长度 20位等等。
            //  	 String orderNumber = "xxxx";
            //获取客户端的ip地址
            String spbill_create_ip = getIpAddr(request);
            //将支付业务下沉到service层

            result = senseAgroOrderService.wxPay(spbill_create_ip, openId, orderNumber );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return PayUtil.toJson(result);
    }

    //这里是支付回调接口，微信支付成功后会自动调用
    @RequestMapping(value = "/wxNotify", method = RequestMethod.POST)
    public void wxNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("==============进入支付回调接口===============");
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        //sb为微信返回的xml
        String notityXml = sb.toString();
        System.out.println("微信返回的xml"+sb.toString());
        String resXml = "";

        Map map = PayUtil.doXMLParse(notityXml);

        String returnCode = (String) map.get("return_code");
        if ("SUCCESS".equals(returnCode)) {

            //验证签名是否正确
            Map<String, String> validParams = PayUtil.paraFilter(map);  //回调验签时需要去除sign和空值参数
            String prestr = PayUtil.createLinkString(validParams);

            //根据微信官网的介绍，此处不仅对回调的参数进行验签，还需要对返回的金额与系统订单的金额进行比对等
            if (PayUtil.verify(prestr, (String) map.get("sign"), WechatConfig.key, "utf-8")) {

                /**此处添加业务逻辑代码start**/
                //注意要判断微信支付重复回调，支付成功后微信会重复的进行回调
                System.out.println("prestr"+prestr);
                System.out.println("业务结果"+map.get("result_code"));
                System.out.println("openid"+map.get("openid"));
                System.out.println("微信支付单号"+map.get("transaction_id"));
                System.out.println("商户支付单号"+map.get("out_trade_no"));
                System.out.println("订单金额"+map.get("total_fee"));
                System.out.println("错误"+map.get("err_code"));
                System.out.println("时间"+map.get("time_end"));
                //将微信回调所传回的值加入wx_user对象 -----保存到数据库
                wx_user wx_user= new wx_user();
                wx_user.setResulet_code((String) map.get("result_code"));
                wx_user.setOpenid((String) map.get("openid"));
                wx_user.setTransaction_id((String) map.get("transaction_id"));
                wx_user.setOut_trade_no((String) map.get("out_trade_no"));
                wx_user.setTotal_fee((String) map.get("total_fee"));
                wx_user.setErr_code((String) map.get("err_code"));
                wx_user.setEnd_time((String)map.get("time_end"));
                //防止重复添加,微信可能重复回调

                //动态设置common库
                DynamicDataSourceHolder.setDataSource("dataSource6");
                int aa=yxcxService.findWXuser(wx_user.getOpenid());
                if( aa== 0){
                    int bb=yxcxService.insertWXuser(wx_user);
                    System.out.println(bb);
                    if(bb>0){
                        System.out.println("信息保存成功");
                    }else {
                        System.out.println("信息保存失败");
                    }
                }else {
                    System.out.println("openid已存在");
                }

                /**此处添加业务逻辑代码end**/


                //通知微信服务器已经支付成功
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
            }
        } else {
            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                    + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
        }

        BufferedOutputStream out = new BufferedOutputStream(
                response.getOutputStream());
        out.write(resXml.getBytes());
        out.flush();
        out.close();
    }

    //获取IP
    private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }

}
