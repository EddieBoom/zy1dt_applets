package com.zy1dt.entity;

public class YxDetailed {
    private String gbdm;//国标代码
    private String yxmc;//院校名称
    private String szdq;//所在地区
    private int sf211;//是否211
    private int sf985;//是否985
    private String jxsj;//建校时间
    private String ls;//隶属
    private String xsrs;//学生人数
    private String bsdgs;//博士点个数
    private String ysrs;//院士人数
    private String ssdgs;//硕士点个数
    private String dz;//地址
    private String dh;//电话
    private String xxwz;//院校网址
    private String zswz;//招生网址
    private String nsbfb;//男生百分比
    private String nvsbfb;//女生百分比
    private String xfxx;//学费信息
    private String jyqk;//就业情况
    private String jj;//简介
    private String dzyj;//电子邮件
    private String zszc;//招生章程
    private String lqgz;//录取规则
    private String logo;//院校图标

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

    public String getSzdq() {
        return szdq;
    }

    public void setSzdq(String szdq) {
        this.szdq = szdq;
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

    public String getJxsj() {
        return jxsj;
    }

    public void setJxsj(String jxsj) {
        this.jxsj = jxsj;
    }

    public String getLs() {
        return ls;
    }

    public void setLs(String ls) {
        this.ls = ls;
    }

    public String getXsrs() {
        return xsrs;
    }

    public void setXsrs(String xsrs) {
        this.xsrs = xsrs;
    }

    public String getBsdgs() {
        return bsdgs;
    }

    public void setBsdgs(String bsdgs) {
        this.bsdgs = bsdgs;
    }

    public String getYsrs() {
        return ysrs;
    }

    public void setYsrs(String ysrs) {
        this.ysrs = ysrs;
    }

    public String getSsdgs() {
        return ssdgs;
    }

    public void setSsdgs(String ssdgs) {
        this.ssdgs = ssdgs;
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    public String getDh() {
        return dh;
    }

    public void setDh(String dh) {
        this.dh = dh;
    }

    public String getXxwz() {
        return xxwz;
    }

    public void setXxwz(String xxwz) {
        this.xxwz = xxwz;
    }

    public String getZswz() {
        return zswz;
    }

    public void setZswz(String zswz) {
        this.zswz = zswz;
    }

    public String getNsbfb() {
        return nsbfb;
    }

    public void setNsbfb(String nsbfb) {
        this.nsbfb = nsbfb;
    }

    public String getNvsbfb() {
        return nvsbfb;
    }

    public void setNvsbfb(String nvsbfb) {
        this.nvsbfb = nvsbfb;
    }

    public String getXfxx() {
        return xfxx;
    }

    public void setXfxx(String xfxx) {
        this.xfxx = xfxx;
    }

    public String getJyqk() {
        return jyqk;
    }

    public void setJyqk(String jyqk) {
        this.jyqk = jyqk;
    }

    public String getJj() {
        return jj;
    }

    public void setJj(String jj) {
        this.jj = jj;
    }

    public String getDzyj() {
        return dzyj;
    }

    public void setDzyj(String dzyj) {
        this.dzyj = dzyj;
    }

    public String getZszc() {
        return zszc;
    }

    public void setZszc(String zszc) {
        this.zszc = zszc;
    }

    public String getLqgz() {
        return lqgz;
    }

    public void setLqgz(String lqgz) {
        this.lqgz = lqgz;
    }

    public String getLogo(){
        return "http://img.gkzyydt.com/upload/img/logo/"+this.getGbdm()+".jpg";
    }
}
