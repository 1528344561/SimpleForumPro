package com.example.simpleforumpro.controller;

import com.example.simpleforumpro.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
@GetMapping("/list")
    public Result<String> list(/*@RequestHeader(name="Authorization")String token, HttpServletResponse response*/){
//        try{
//            Map<String,Object> claims =JwtUtil.parseToken(token);
//        }catch (Exception e){
//            //http响应状态码
//            response.setStatus(401);
//            return Result.error("未登录");
//        }

        return Result.success("所有文章数据...");
    }
}
