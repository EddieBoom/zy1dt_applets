package com.zy1dt.service.impl;

import com.zy1dt.entity.Order;
import com.zy1dt.entity.WechatConfig;
import com.zy1dt.service.YxcxService;
import com.zy1dt.util.DynamicDataSourceHolder;
import com.zy1dt.util.PayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class SenseAgroOrderService {

    @Autowired
    private YxcxService yxcxService;

    public Map wxPay(String spbill_create_ip, String openId, String orderNumber) {
        Map<String, Object> payMap = new HashMap<String, Object>();//返回给小程序端需要的参数
        try {
            //生成的随机字符串
            String nonce_str = getRandomStringByLength(32);
            //商品名称
            //todo
            //动态设置common库
            DynamicDataSourceHolder.setDataSource("dataSource6");

            Order order =yxcxService.findorder();

            String body = order.getBody();
            System.out.println("商品名称"+order.getBody());
            //订单金额
            String price=order.getPrice();
            System.out.println("商品价格"+order.getPrice());
            //组装参数，用户生成统一下单接口的签名
//            logger.info("----------下单接口签名-------");
            System.out.println("----------下单接口签名-------");
            Map<String, String> packageParams = new HashMap<String,String>();
            packageParams.put("appid", WechatConfig.appid);
            packageParams.put("mch_id", WechatConfig.mch_id);
            packageParams.put("nonce_str", nonce_str);
            packageParams.put("body", body);
            packageParams.put("out_trade_no", orderNumber);//商户订单号,自己的订单ID
            packageParams.put("total_fee", price + "");//支付金额，这边需要转成字符串类型，否则后面的签名会失败
            packageParams.put("spbill_create_ip", spbill_create_ip);
            packageParams.put("notify_url", WechatConfig.notify_url);//支付成功后的回调地址
            packageParams.put("trade_type", WechatConfig.TRADETYPE);//支付方式
            packageParams.put("openid", openId + "");//用户的openID，自己获取
            String prestr = PayUtil.createLinkString(packageParams); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
//            logger.info("----------prestr:" + prestr);
//            logger.info("----------调用统一下单接口-------");

            System.out.println("----------调用统一下单接口-------");
            //MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
            String mysign = PayUtil.sign(prestr, WechatConfig.key, "utf-8").toUpperCase();
//            logger.info("----------mysign:" + mysign);
            System.out.println("----------mysign:" + mysign);

            //拼接统一下单接口使用的xml数据，要将上一步生成的签名一起拼接进去
            String xml = "<xml>" + "<appid>" + WechatConfig.appid + "</appid>"
                    + "<body><![CDATA[" + body + "]]></body>"
                    + "<mch_id>" + WechatConfig.mch_id + "</mch_id>"
                    + "<nonce_str>" + nonce_str + "</nonce_str>"
                    + "<notify_url>" + WechatConfig.notify_url + "</notify_url>"
                    + "<openid>" + openId + "</openid>"
                    + "<out_trade_no>" + orderNumber + "</out_trade_no>"
                    + "<spbill_create_ip>" + spbill_create_ip + "</spbill_create_ip>"
                    + "<total_fee>" + price + "</total_fee>"//支付的金额，单位：分
                    + "<trade_type>" + WechatConfig.TRADETYPE + "</trade_type>"
                    + "<sign>" + mysign + "</sign>"
                    + "</xml>";

            //调用统一下单接口，并接受返回的结果
            String result = PayUtil.httpRequest(WechatConfig.pay_url, "POST", xml);

//            logger.info("----------result:" + result);
            System.out.println("----------result:" + result);

            // 将解析结果存储在HashMap中
            Map map = PayUtil.doXMLParse(result);
            String return_code = (String) map.get("return_code");//返回状态码
            String result_code = (String) map.get("result_code");//返回状态码
            String err_code = (String) map.get("err_code");//返回状态码
            String err_code_des = (String) map.get("err_code_des");//返回状态码

            if (return_code.equals("SUCCESS") || return_code.equals(result_code)) {
                String prepay_id = (String) map.get("prepay_id");//返回的预付单信息
                payMap.put("nonceStr", nonce_str);
                payMap.put("package", "prepay_id=" + prepay_id);
                Long timeStamp = System.currentTimeMillis() / 1000;
                payMap.put("timeStamp", timeStamp + "");//这边要将返回的时间戳转化成字符串，不然小程序端调用wx.requestPayment方法会报签名错误
                //拼接签名需要的参数
                String stringSignTemp = "appId=" + WechatConfig.appid + "&nonceStr=" + nonce_str + "&package=prepay_id=" + prepay_id + "&signType=MD5&timeStamp=" + timeStamp;
                //再次签名，这个签名用于小程序端调用wx.requesetPayment方法
                String paySign = PayUtil.sign(stringSignTemp, WechatConfig.key, "utf-8").toUpperCase();
//                logger.info("=======================第二次签名：", paySign + "============ ======");
                System.out.println("=======================第二次签名："+ paySign + "============ ======");
                payMap.put("paySign", paySign);
            } else {
//                logger.info("----------统一下单失败-------");
                System.out.println("----------统一下单失败-------");
                return payMap;
            }
            //	senseAgroOrderService.insert(payOperation);
            payMap.put("appid", WechatConfig.appid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return payMap;
    }

    //获取随机字符串
    private String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
