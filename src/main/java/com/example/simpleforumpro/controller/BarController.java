package com.example.simpleforumpro.controller;

import com.example.simpleforumpro.pojo.Bar;
import com.example.simpleforumpro.pojo.Result;
import com.example.simpleforumpro.service.BarService;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bar")
public class BarController {
    @Autowired
    private BarService barService;

    @PostMapping("/add")
    public Result add(@RequestBody @Validated Bar bar){
        barService.addBar(bar);
        return Result.success("ok");
//        return Result.success("wait....");
    }
    @GetMapping("/list")
    public Result<List<Bar>> list(){
        List<Bar> barList = barService.list();
        return Result.success(barList);
    }

    @GetMapping("/barInfo")
    public Result findBarByBarId(String barName){
        Bar bar = barService.findByBarName(barName);
        if(bar==null){
            return Result.error("不存在的贴吧");
        }else {
            return Result.success(bar);
        }
    }
}
