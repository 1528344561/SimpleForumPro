package com.example.simpleforumpro.mapper;

import com.example.simpleforumpro.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where account=#{account}")
    User findByUserName(String account);

    @Insert("insert into user(account,password,create_time,update_time)" +
            " values(#{account},#{password},now(),now())")
    void add(String account, String password);
}
