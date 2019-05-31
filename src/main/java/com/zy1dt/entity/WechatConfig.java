package com.zy1dt.entity;

public class WechatConfig {
    //小程序appid
    public static final String appid = "wxb0eae04ed4d57169";
    //微信支付的商户id
    public static final String mch_id = "1407813302";
    //微信支付的商户密钥
    public static final String key = "f54b1b59a16855567eb8ec8d6d0b077c";
    //支付成功后的服务器回调url
    public static final String notify_url = "https://jbt1.zy1dt.com/pay/wxNotify";
    //签名方式，固定值
    public static final String SIGNTYPE = "MD5";
    //交易类型，小程序支付的固定值为JSAPI
    public static final String TRADETYPE = "JSAPI";
    //微信统一下单接口地址
    public static final String pay_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    //小程序AppSecret
    public static final String appsecret="1fff4a67fb4094b94e95bfffd06ec418";
    //获取openid地址
    public static final String openid_url="https://api.weixin.qq.com/sns/jscode2session?";

}
