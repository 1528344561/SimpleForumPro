package com.example.simpleforumpro.interceptors;

import com.example.simpleforumpro.JwtUtil.JwtUtil;
import com.example.simpleforumpro.pojo.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");

        try{
            Map<String,Object> claims = JwtUtil.parseToken(token);
            return true;
        }catch (Exception e){
            //http响应状态码
            response.setStatus(401);
            return false;
        }
    }
}
