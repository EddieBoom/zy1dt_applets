package com.zy1dt.entity;

//院校推荐的表
public class Yxcx {
    private float lqgl;//录取概率
    private String yxxh;//院校序号
    private String gbdm;//国标代码
    private String sb;//省标
    private String yxmc;//院校名称
    private String szdqmc;//所在地区名称名称
    private String szdq;//所在地区
    private int bxlx;//办学类型
    private int sf211;//是否211
    private int sf985;//是否985
    private int yfyjsy;//是否研究生院
    private int sfsyl;//
    private String ls;//隶属
    private String xxlb;//学校类别
    private String xxlbmc;//学校类别名称
    private String ssdgs;//硕士点个数
    private String bsdgs;//博士点个数
    private String zdxk;//重点学科
    private int kl;//科类
    private int pm;//排名
    private int pc;//批次
    private int xc1;//线差1
    private int xc2;//线差2
    private int xc3;//线差3
    private int jnjhrs;//计划数
    private int xzyx;//新增院校
    private int yctdf;//预测投档分
    private String logo;//
    public String getLogo(){
        return "http://img.gkzyydt.com/upload/img/logo/"+this.getGbdm()+".jpg";
    }

    public String getYxxh() {
        return yxxh;
    }

    public void setYxxh(String yxxh) {
        this.yxxh = yxxh;
    }

    public String getGbdm() {
        return gbdm;
    }

    public void setGbdm(String gbdm) {
        this.gbdm = gbdm;
    }

    public String getSb() {
        return sb;
    }

    public void setSb(String sb) {
        this.sb = sb;
    }

    public String getYxmc() {
        return yxmc;
    }

    public void setYxmc(String yxmc) {
        this.yxmc = yxmc;
    }

    public String getSzdqmc() {
        return szdqmc;
    }

    public void setSzdqmc(String szdqmc) {
        this.szdqmc = szdqmc;
    }

    public String getSzdq() {
        return szdq;
    }

    public void setSzdq(String szdq) {
        this.szdq = szdq;
    }

    public int getBxlx() {
        return bxlx;
    }

    public void setBxlx(int bxlx) {
        this.bxlx = bxlx;
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

    public int getYfyjsy() {
        return yfyjsy;
    }

    public void setYfyjsy(int yfyjsy) {
        this.yfyjsy = yfyjsy;
    }

    public int getSfsyl() {
        return sfsyl;
    }

    public void setSfsyl(int sfsyl) {
        this.sfsyl = sfsyl;
    }

    public String getLs() {
        return ls;
    }

    public void setLs(String ls) {
        this.ls = ls;
    }

    public String getXxlb() {
        return xxlb;
    }

    public void setXxlb(String xxlb) {
        this.xxlb = xxlb;
    }

    public String getXxlbmc() {
        return xxlbmc;
    }

    public void setXxlbmc(String xxlbmc) {
        this.xxlbmc = xxlbmc;
    }

    public String getSsdgs() {
        return ssdgs;
    }

    public void setSsdgs(String ssdgs) {
        this.ssdgs = ssdgs;
    }

    public String getBsdgs() {
        return bsdgs;
    }

    public void setBsdgs(String bsdgs) {
        this.bsdgs = bsdgs;
    }

    public String getZdxk() {
        return zdxk;
    }

    public void setZdxk(String zdxk) {
        this.zdxk = zdxk;
    }

    public int getKl() {
        return kl;
    }

    public void setKl(int kl) {
        this.kl = kl;
    }

    public int getPm() {
        return pm;
    }

    public void setPm(int pm) {
        this.pm = pm;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getXc1() {
        return xc1;
    }

    public void setXc1(int xc1) {
        this.xc1 = xc1;
    }

    public int getXc2() {
        return xc2;
    }

    public void setXc2(int xc2) {
        this.xc2 = xc2;
    }

    public int getXc3() {
        return xc3;
    }

    public void setXc3(int xc3) {
        this.xc3 = xc3;
    }

    public int getJnjhrs() {
        return jnjhrs;
    }

    public void setJnjhrs(int jnjhrs) {
        this.jnjhrs = jnjhrs;
    }

    public int getXzyx() {
        return xzyx;
    }

    public void setXzyx(int xzyx) {
        this.xzyx = xzyx;
    }

    public int getYctdf() {
        return yctdf;
    }

    public void setYctdf(int yctdf) {
        this.yctdf = yctdf;
    }

    public float getLqgl() {
        return lqgl;
    }

    public void setLqgl(float lqgl) {
        this.lqgl = lqgl;
    }
}
