package com.zy1dt.service;
import com.zy1dt.entity.*;
import com.zy1dt.mapper.YxcxMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface YxcxService {

    String find0(String subject,String batch,String fraction);//查询冲刺型学校数量
    String find1(String subject,String batch,String fraction);//查询稳妥型学校数量
    String find2(String subject,String batch,String fraction);//查询保守型学校数量
    List<Yx> allyx(int pages);//查询所有学校
    int findWXuser( String openid);//查询微信用户是否付费
    int insertWXuser(wx_user wx_user);//付费用户信息添加
    List<YxDetailed> findYxDetailed( String gbdm);//查询学校详细信息
    List<Yx> conditionAll(String province, String type,String level,int pages);//条件查询所有学校
    String finddqbm(String name);//查询省份的地区编码
    List<Yxcx> findYx( int type, String subject, String batch,  String fraction,int pages);
    List<Yxcx> ConFindYx( int yxtype,String subject,  String batch,String fraction,int pages ,String provinces,String types,String level);
    Order findorder();
    Yxcx experience(String subject,  String batch,  String fraction);//体验冲刺型
    Yxcx experience1(String subject, String batch,  String fraction);//体验稳妥型
    Yxcx experience2(String subject,  String batch,  String fraction);//体验保守型
}
