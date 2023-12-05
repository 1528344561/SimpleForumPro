package com.example.simpleforumpro.service.impl;

import com.example.simpleforumpro.mapper.UserMapper;
import com.example.simpleforumpro.pojo.User;
import com.example.simpleforumpro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void register(String account, String password) {
        //可以加密密码.加入到数据库之前就加密.
        userMapper.add(account,password);
    }
}
