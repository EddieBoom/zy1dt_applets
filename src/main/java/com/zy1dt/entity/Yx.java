package com.zy1dt.entity;

/*
* 查询所有院校所用实体 19/5/7
* */
public class Yx {
    private String gbdm;//国标代码
    private String yxmc;//院校名称
    private int sf211;//是否211
    private int sf985;//是否985
    private String dqmc;//地区名称
    private String xxlbmc;//学校类别名称
    private String bxlbmc;//办学类别名称
    private String logo;//院校图标

    public String getDqmc() {
        return dqmc;
    }

    public void setDqmc(String dqmc) {
        this.dqmc = dqmc;
    }

    public String getXxlbmc() {
        return xxlbmc;
    }

    public void setXxlbmc(String xxlbmc) {
        this.xxlbmc = xxlbmc;
    }

    public String getBxlbmc() {
        return bxlbmc;
    }

    public void setBxlbmc(String bxlbmc) {
        this.bxlbmc = bxlbmc;
    }

    public String getGbdm() {
        return gbdm;
    }

    public void setGbdm(String gbdm) {
        this.gbdm = gbdm;
    }

    public String getYxmc() {
        return yxmc;
    }

    public void setYxmc(String yxmc) {
        this.yxmc = yxmc;
    }

    public int getSf211() {
        return sf211;
    }

    public void setSf211(int sf211) {
        this.sf211 = sf211;
    }

    public int getSf985() {
        return sf985;
    }

    public void setSf985(int sf985) {
        this.sf985 = sf985;
    }

    public String getLogo(){
        return "http://img.gkzyydt.com/upload/img/logo/"+this.getGbdm()+".jpg";
    }

}
