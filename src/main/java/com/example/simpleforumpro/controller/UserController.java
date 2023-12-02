package com.example.simpleforumpro.controller;

import com.example.simpleforumpro.pojo.Result;
import com.example.simpleforumpro.pojo.User;
import com.example.simpleforumpro.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    @Validated
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String account,@Pattern(regexp = "^\\S{5,16}$") String password){
        //查询用户
        User u = userService.findByUserAccount(account);
        if(u==null) {
            //注册
            userService.register(account,password);
            return Result.success();
        }
        else {
            return Result.error("用户名已存在");
        }
    }
}
