package com.zy1dt.mapper;

import com.zy1dt.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YxcxMapper {

     String find0(@Param("subject") String subject,@Param("batch") String batch, @Param("fraction") String fraction);//查询冲刺型学校数量
     String find1(@Param("subject") String subject,@Param("batch") String batch, @Param("fraction") String fraction);//查询稳妥型学校数量
     String find2(@Param("subject") String subject,@Param("batch") String batch, @Param("fraction") String fraction);//查询型学保守校数量
     List<Yx> allyx(int pages);//查询所有学校
     int findWXuser(@Param("openid") String openid);//查询是否付费用户
     int insertWXuser(wx_user wx_user);//付费用户信息添加
     List<YxDetailed> findYxDetailed(@Param("gbdm") String gbdm);//查询学校详细信息
     List<Yx> conditionAll(@Param("province") String province,@Param("type") String type,@Param("level") String level,@Param("pages") int pages);//条件查询所有学校
     String finddqbm(@Param("name") String name);//查询省份的地区编码
     List<Yxcx> findYx(@Param("type") int type,@Param("subject") String subject, @Param("batch") String batch, @Param("fraction") String fraction,@Param("pages") int pages);
     List<Yxcx> ConFindYx(@Param("yxtype") int yxtype,@Param("subject") String subject, @Param("batch") String batch, @Param("fraction") String fraction,@Param("pages") int pages ,@Param("provinces") String provinces,@Param("types") String types,@Param("level") String level);
     Order findorder();
     Yxcx experience(@Param("subject") String subject, @Param("batch") String batch, @Param("fraction") String fraction);
     Yxcx experience1(@Param("subject") String subject, @Param("batch") String batch, @Param("fraction") String fraction);
     Yxcx experience2(@Param("subject") String subject, @Param("batch") String batch, @Param("fraction") String fraction);
}
