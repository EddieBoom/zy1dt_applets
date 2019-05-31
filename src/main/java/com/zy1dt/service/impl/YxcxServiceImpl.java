package com.zy1dt.service.impl;

import com.zy1dt.entity.*;
import com.zy1dt.mapper.YxcxMapper;
import com.zy1dt.service.YxcxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YxcxServiceImpl implements YxcxService {
    @Autowired
    private YxcxMapper yxcxMapper;

    public String find0(String subject, String batch, String fraction) {
        return yxcxMapper.find0(subject,batch,fraction);
    }

    public String find1(String subject, String batch, String fraction) {
        return yxcxMapper.find1(subject,batch,fraction);
    }

    public String find2(String subject, String batch, String fraction) {
        return yxcxMapper.find2(subject,batch,fraction);
    }


    public List<Yx> allyx(int pages) {
        return yxcxMapper.allyx(pages);
    }

    public int findWXuser(String openid) {
        return yxcxMapper.findWXuser(openid);
    }

    public int insertWXuser(wx_user wx_user) {
        return yxcxMapper.insertWXuser(wx_user);
    }

    public List<YxDetailed> findYxDetailed(String gbdm) {
        return yxcxMapper.findYxDetailed(gbdm);
    }
    public List<Yx> conditionAll(String province, String type, String level, int pages) {
        return yxcxMapper.conditionAll(province,type,level,pages);
    }

    public String finddqbm(String name) {
        return yxcxMapper.finddqbm(name);
    }

    public List<Yxcx> findYx(int type, String subject, String batch, String fraction, int pages) {
        return yxcxMapper.findYx(type,subject,batch,fraction,pages);
    }

    public List<Yxcx> ConFindYx(int yxtype, String subject, String batch, String fraction, int pages, String provinces, String types, String level) {
        return yxcxMapper.ConFindYx(yxtype,subject,batch,fraction,pages,provinces,types,level);
    }

    public Order findorder() {
        return yxcxMapper.findorder();
    }

    public Yxcx experience(String subject, String batch, String fraction) {
        return yxcxMapper.experience(subject,batch,fraction);
    }

    public Yxcx experience1(String subject, String batch, String fraction) {
        return yxcxMapper.experience1(subject,batch,fraction);
    }

    public Yxcx experience2(String subject, String batch, String fraction) {
        return  yxcxMapper.experience2(subject,batch,fraction);
    }
}
