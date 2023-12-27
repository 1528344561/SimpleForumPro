package com.example.simpleforumpro.service;

import com.example.simpleforumpro.pojo.User;

public interface UserService {
    User findByUserAccount(String account);
    User findByUserId(int userId);

    void register(String account, String password);

    void updateProfile(User u);

    void updateAvatar(String avatarUrl);
}
