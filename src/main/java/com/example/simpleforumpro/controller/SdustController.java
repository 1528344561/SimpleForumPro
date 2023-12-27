package com.example.simpleforumpro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SdustController {
    @RequestMapping("/sdust")
    public String fun() {
        //"redirect:要访问的相对网址或绝对网址?参数名="+参数值;
        return "redirect:https://www.baidu.com";
    }

}
