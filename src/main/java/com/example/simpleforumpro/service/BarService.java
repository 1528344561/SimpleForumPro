package com.example.simpleforumpro.service;

import com.example.simpleforumpro.pojo.Bar;

import java.util.List;

public interface BarService {


    List<Bar> list() ;

    Bar findByBarId(int id);

    Bar findByBarName(String barName);
    void addBar(Bar bar);


}
