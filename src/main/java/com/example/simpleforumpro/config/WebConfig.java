package com.example.simpleforumpro.config;

import com.example.simpleforumpro.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .excludePathPatterns
                        ("/hello",
                         "/user/login", "/user/register",
                         "/test/get_token", "/test/test_token",
                         "/file/**",
                                "/bar/");//为什么exclude了还是报401错误? 之前没加**,需要加/**才能匹配后面的包含的,不然只会精确匹配file
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //和页面有关的静态目录都放在项目的static目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //上传的图片在D盘下的storage目录下，访问路径如：http://localhost:8081/storage/1.jpg
        //其中image表示访问的前缀。"file:D:/storage/"是文件真实的存储路径
        registry.addResourceHandler("/file/**").addResourceLocations("file:C:/photos/");
    }
}
