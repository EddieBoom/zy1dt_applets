package com.zy1dt.util;

import com.zy1dt.entity.Yxcx;
import com.zy1dt.service.YxcxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * 工具类，
 * **/
public  class Tool {

    @Autowired
    private  YxcxService yxcxService;

    //省份处理,动态更改数据库 0 1 2 3 4对应'湖南', '湖北', '四川', '贵州', '河南'
    public  String province(String province){
        String ataSource="dataSource2";
        if(province.equals("0")){
            ataSource= "dataSource2";
        }else if (province.equals("1")){
            ataSource= "dataSource1";
        }else if (province.equals("2")){
            ataSource= "dataSource4";
        }else if (province.equals("3")){
            ataSource= "dataSource5";
        }else if(province.equals("4")){
            ataSource= "dataSource3";
        }
        return ataSource;
    }


}
