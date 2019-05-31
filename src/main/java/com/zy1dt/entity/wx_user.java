package com.zy1dt.entity;

public class wx_user {
    private String openid;//用户唯一标识
    private String total_fee;//订单金额
    private String out_trade_no;//商户支付单号
    private String transaction_id;//微信支付单号
    private String err_code;//错误代码
    private String resulet_code;//业务结果
    private String end_time;//付款结束时间
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getResulet_code() {
        return resulet_code;
    }

    public void setResulet_code(String resulet_code) {
        this.resulet_code = resulet_code;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
}
