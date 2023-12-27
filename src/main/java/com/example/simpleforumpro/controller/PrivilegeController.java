package com.example.simpleforumpro.controller;

import com.example.simpleforumpro.pojo.Result;
import com.example.simpleforumpro.service.PrivilegeService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/privilege")
@RestController
public class PrivilegeController {
    @Autowired
    PrivilegeService privilegeService;

    @GetMapping("/privilegeInfo")
    Result getPrivilegeNumByUserId(int userId){
        Integer privilegeNum = privilegeService.getPrivilegeNumByUserId(userId);
        if(privilegeNum==null){
            privilegeNum = Integer.valueOf(0);
        }
        return Result.success(privilegeNum.intValue());
    }
}
