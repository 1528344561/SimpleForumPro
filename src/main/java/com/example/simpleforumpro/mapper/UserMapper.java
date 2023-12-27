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
    @Select("select * from user where id=#{userId}")
    User findByUserId(int userId);
    @Insert("insert into user(account,password,nickname,create_time,update_time)" +
            " values(#{account},#{password},'默认用户名',now(),now())")
    void add(String account, String password);

    @Update("update user set nickname=#{nickname},user_pic=#{userPic}," +
            "update_time=now() where id=#{id}")
    void update(User u);

    @Update("update user set user_pic=#{avatarUrl}," +
            "update_time=now() where id=#{id}")
    void updateAvatar(String avatarUrl,int id);
//    @Update("update user set nickname={}")
//    void modify(int id,String newAccount,String newPassword);
}
