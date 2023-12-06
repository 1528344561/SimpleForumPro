package com.example.simpleforumpro.mapper;

import com.example.simpleforumpro.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("select * from user where account=#{account}")
    User findByUserName(String account);

    @Insert("insert into user(account,password,create_time,update_time)" +
            " values(#{account},#{password},now(),now())")
    void add(String account, String password);

    @Update("update user set nickname=#{nickname}," +
            "update_time=now() where id=#{id}")
    void update(int id,String nickname);

    @Update("update user set user_pic=#{avatarUrl}," +
            "update_time=now() where id=#{id}")
    void updateAvatar(String avatarUrl,int id);
//    @Update("update user set nickname={}")
//    void modify(int id,String newAccount,String newPassword);
}
