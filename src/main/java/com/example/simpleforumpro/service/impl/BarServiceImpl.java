package com.example.simpleforumpro.service.impl;

import com.example.simpleforumpro.mapper.BarMapper;
import com.example.simpleforumpro.pojo.Bar;
import com.example.simpleforumpro.service.BarService;
import com.example.simpleforumpro.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BarServiceImpl implements BarService {
    @Autowired
    private BarMapper barMapper;
    @Override
    public Bar findByBarId(int id){
        Bar bar = barMapper.findByBarId(id);
        return bar;
    }

    @Override
    public Bar findByBarName(String barName) {
        Bar bar = barMapper.findByBarName(barName);
        return bar;
    }

    @Override
    public void addBar(Bar bar) {
        Map<String,Object> map = ThreadLocalUtil.get();
        int userId = (int)(map.get("id"));

        barMapper.addBar(bar.getBarName(),bar.getBarIntroduction(),userId,bar.getBarPic());
    }

    @Override
    public List<Bar> list(){
        List<Bar> barList = barMapper.list();
        return barList;
    }
}
