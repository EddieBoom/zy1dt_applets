package com.zy1dt.entity;

public class Order {
    private String body;//商品名称

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String price;//商品价格 单位：分
}
