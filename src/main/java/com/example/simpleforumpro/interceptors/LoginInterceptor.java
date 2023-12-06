package com.example.simpleforumpro.interceptors;

import com.example.simpleforumpro.utils.JwtUtil;
import com.example.simpleforumpro.utils.ThreadLocalUtil;
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

            //把用户数据存储到ThreadLocal
            ThreadLocalUtil.set(claims);

            return true;
        }catch (Exception e){
            //http响应状态码 401 - 未认证
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalUtil.remove();
    }
}
