package com.example.simpleforumpro.controller;

import com.example.simpleforumpro.utils.JwtUtil;
import com.example.simpleforumpro.pojo.Result;
import com.example.simpleforumpro.pojo.User;
import com.example.simpleforumpro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    UserService userService;
    @GetMapping("/test_token")
    public Result<String> testToken(String token){
        return Result.success(JwtUtil.parseToken(token).toString());
    }
    @GetMapping("/get_token")
    public Result<String> genToken(String account){
        User u = userService.findByUserAccount(account);
        if(u==null){
            return Result.error("用户名不存在");
        }
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",u.getId());
        claims.put("account",u.getAccount());
        String token = JwtUtil.genToken(claims);
        return Result.success(token);
//        return Result.success(JwtUtil.parseToken(token).toString());
    }
}
