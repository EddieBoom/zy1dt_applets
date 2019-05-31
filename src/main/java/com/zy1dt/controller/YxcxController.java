package com.zy1dt.controller;

import com.zy1dt.entity.*;
import com.zy1dt.service.YxcxService;
import com.zy1dt.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/yxcx")
public class YxcxController {

    @Autowired
    private YxcxService yxcxService;

    /**
    * 院校个数controller
    * */
    @RequestMapping(value = "/yxtj",method = RequestMethod.GET)
    @ResponseBody
    public CollegeType yxtj( String province, String subject, String batch, String fraction){

        //subject:科类 batch:批次  fraction:分数 province:省份
        //设置省份数据库
        DynamicDataSourceHolder.setDataSource(new Tool().province(province));
        CollegeType collegeType= new CollegeType();
        collegeType.setSprint(yxcxService.find0(subject,batch,fraction));//冲刺型
        collegeType.setSafe(yxcxService.find1(subject,batch,fraction));//稳妥型
        collegeType.setConservative(yxcxService.find2(subject,batch,fraction));//保守型
        return collegeType;
    }


    /**
     * 院校推荐controller
     * */
    @RequestMapping(value = "/yxcx",method = RequestMethod.GET)
    @ResponseBody
    public List<Yxcx> yxcx(String type,String page,String province, String subject, String batch, String fraction){
        //分页查询
        int pages=Integer.valueOf(page);
        if(pages==1){
            pages=0;
        }else {
            pages=(pages-1)*20;
        }

        //设置省份数据库
        DynamicDataSourceHolder.setDataSource(new Tool().province(province));

        int types=Integer.valueOf(type);
        List<Yxcx> yxcx = yxcxService.findYx(types,subject,batch,fraction,pages);
        return yxcx;
    }


    /***
     * 条件查询推荐院校
     * **/
    @RequestMapping(value = "/ConFindYX",method = RequestMethod.GET)
    @ResponseBody
    public List<Yxcx> ConFindYX(String type,String pages,String province,String types,String level,String pro, String subject, String batch, String fraction){

        //分页查询
        int pagess=Integer.valueOf(pages);
        if(pagess==1){
            pagess=0;
        }else {
            pagess=(pagess-1)*20;
        }

        String provinces;
        if(province.equals("地区")){
            provinces=null;
        }else {
            provinces=yxcxService.finddqbm(province);
        }

        //设置省份数据库
        DynamicDataSourceHolder.setDataSource(new Tool().province( pro));

        int yxtype=Integer.valueOf(type);

        List<Yxcx> list=yxcxService.ConFindYx(yxtype,subject,batch,fraction,pagess,provinces,types,level);

        return list;
    }


    /**
     * 查询所有院校controller
     * */
    @RequestMapping(value = "/allyx", method= RequestMethod.GET)
    @ResponseBody
    public List<Yx> findall(String page){
        //动态设置common库
        DynamicDataSourceHolder.setDataSource("dataSource6");
        //分页查询
        int pages=Integer.valueOf(page);
        if(pages==1){
            pages=0;
        }else {
            pages=(pages-1)*20;
        }
        List<Yx> list=yxcxService.allyx(pages);

        return list;
    }

    /**
     * 通过code向微信服务器发起请求，获取openid 然后查询数据库是否为付费用户
     **/
    @RequestMapping(value = "/getOpenid",method = RequestMethod.GET)
    @ResponseBody
    public Map getOpenid(String code){
        HttpRequest httpRequest = new HttpRequest();
        String res=httpRequest.get(WechatConfig.openid_url+"appid="+WechatConfig.appid+"&secret="+WechatConfig.appsecret+"&js_code="+code+"&grant_type=authorization_code");
        //动态设置common库
        DynamicDataSourceHolder.setDataSource("dataSource6");
        WechatOpenID wechatOpenID= (WechatOpenID) JsonUtil.jsonToBean(res,new WechatOpenID());
        String userYN= String.valueOf(yxcxService.findWXuser(wechatOpenID.getOpenid()));
        Order order =yxcxService.findorder();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("openid",wechatOpenID.getOpenid());
        map.put("user",userYN);
        map.put("price",order.getPrice());
        return map;
    }

    /**
     * 查询院校详细信息
     * **/
    @RequestMapping(value = "/findYxDetailed" ,method = RequestMethod.GET)
    @ResponseBody
    public List<YxDetailed> findYxDetailed(String gbdm){
        //动态设置common库
        DynamicDataSourceHolder.setDataSource("dataSource6");
        List<YxDetailed> yxDetailed=yxcxService.findYxDetailed(gbdm);
        return yxDetailed;
    }

    /**
     * 所有院校条件查询
     * **/
    @RequestMapping(value = "/findCondition",method = RequestMethod.GET)
    @ResponseBody
    public List<Yx> findCondition(String province,String type,String level,String pages){
        //动态设置common库
        DynamicDataSourceHolder.setDataSource("dataSource6");
        //分页查询
        int page=Integer.valueOf(pages);
        if(page==1){
            page=0;
        }else {
            page=(page-1)*20;
        }
        String provinces;
        if(province.equals("地区")){
            provinces=null;
        }else {
            provinces=yxcxService.finddqbm(province);
        }
        List<Yx> list=yxcxService.conditionAll(provinces,type,level,page);
        return list;

    }

    /**
     * 体验查看
     * **/
    @RequestMapping(value = "experience",method = RequestMethod.GET)
    @ResponseBody
    public List<Yxcx> experience(String province, String subject, String batch, String fraction){

        //设置省份数据库
        DynamicDataSourceHolder.setDataSource(new Tool().province((province)));

        Yxcx yxcx=yxcxService.experience(subject,batch,fraction);
        Yxcx yxcx1=yxcxService.experience1(subject,batch,fraction);
        Yxcx yxcx2=yxcxService.experience2(subject,batch,fraction);
        List<Yxcx> list=new ArrayList<Yxcx>();
        list.add(yxcx);
        list.add(yxcx1);
        list.add(yxcx2);
        return list;
    }


}
