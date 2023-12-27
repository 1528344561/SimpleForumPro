package com.example.simpleforumpro.service.impl;

import com.example.simpleforumpro.mapper.UserMapper;
import com.example.simpleforumpro.pojo.User;
import com.example.simpleforumpro.service.UserService;
import com.example.simpleforumpro.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserAccount(String account) {
        User u = userMapper.findByUserName(account);
        return u;
    }

    @Override
    public User findByUserId(int userId) {
        User u = userMapper.findByUserId(userId);
        return u;
    }

    @Override
    public void register(String account, String password) {
        //可以加密密码.加入到数据库之前就加密.
        userMapper.add(account,password);
    }

    @Override
    public void updateProfile(User u) {
        userMapper.update(u);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String,Object> map = ThreadLocalUtil.get();
        int id = (int)map.get("id");
        userMapper.updateAvatar(avatarUrl,id);
    }

    //    public void modify(String newAccount,String newPassword){
//
//    }
}
