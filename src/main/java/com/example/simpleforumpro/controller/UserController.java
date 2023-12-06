package com.example.simpleforumpro.controller;

import com.example.simpleforumpro.utils.JwtUtil;
import com.example.simpleforumpro.pojo.Result;
import com.example.simpleforumpro.pojo.User;
import com.example.simpleforumpro.service.UserService;
import com.example.simpleforumpro.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String account,@Pattern(regexp = "^\\S{5,16}$") String password){
        User u = userService.findByUserAccount(account);

        if(u==null) {
            return Result.error("账号不存在");
        }

        if(password.equals(u.getPassword())==false) {
            return Result.error("密码错误");
        }

        Map<String,Object> claims = new HashMap<>();
        claims.put("id",u.getId());
        claims.put("account",u.getAccount());
        String token = JwtUtil.genToken(claims);
        return Result.success(token);
    }
//    @GetMapping("/userInfo")
//    public Result<User> getUserInfo(@RequestHeader(name="Authorization")String token){
//        //查询指定用户名的用户
//        String account= (String)JwtUtil.parseToken(token).get("account");
//        User u = userService.findByUserAccount(account);
//        return Result.success(u);
//    }
    @GetMapping("/userInfo")
    public Result<User> getUserInfo(){
        Map<String,Object> map = ThreadLocalUtil.get();

        //查询指定用户名的用户
        String account= (String) map.get("account");
        User u = userService.findByUserAccount(account);
        return Result.success(u);
    }
    @PutMapping("/update")
    public Result<String> update(@RequestBody @Validated User u){
        Map<String,Object> map = ThreadLocalUtil.get();
        if(u.getId()!=(map.get("id"))){
            return Result.error("欲修改的ID与登录ID不匹配");
        }
        userService.updateProfile(u.getId(),u.getNickname());
        return Result.success("ok");
    }
    @PatchMapping("/updateAvatar")
    public Result<String> updateAvatar(@URL String avatarUrl){
        userService.updateAvatar(avatarUrl);
        return Result.success("ok");
    }
    @GetMapping("/profile")
    public Result<String> getProfile(){
        return Result.success("这是一个测试的接口.访问成功.");
    }
    @ExceptionHandler(RuntimeException.class)
    public Result handleValidationException(RuntimeException e) {
//        e.printStackTrace(); //打印异常信息到控制台
        return Result.error((e.getMessage() != null) ? e.getMessage() : "操作失败");
    }
}
