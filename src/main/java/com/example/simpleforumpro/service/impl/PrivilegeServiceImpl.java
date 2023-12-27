package com.example.simpleforumpro.service.impl;

import com.example.simpleforumpro.mapper.PrivilegeMapper;
import com.example.simpleforumpro.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    @Autowired
    PrivilegeMapper privilegeMapper;
    @Override
    public Integer getPrivilegeNumByUserId(int UserId) {
        return privilegeMapper.getPrivilegeNumByUserId(UserId);
    }
}
