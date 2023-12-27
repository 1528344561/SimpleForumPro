package com.example.simpleforumpro.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PrivilegeMapper {
    @Select("select * from privilege where user_id=#{userId}")
    Integer getPrivilegeNumByUserId(int userId);

}
