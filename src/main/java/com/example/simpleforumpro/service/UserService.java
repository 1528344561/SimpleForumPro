package com.example.simpleforumpro.service;

import com.example.simpleforumpro.pojo.User;

public interface UserService {
    User findByUserAccount(String account);
    void register(String account, String password);
}
