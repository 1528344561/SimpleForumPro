package com.example.simpleforumpro.mapper;

import com.example.simpleforumpro.pojo.Bar;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BarMapper {

    @Insert("insert into bar(bar_name,bar_introduction,create_user,bar_pic,create_time,update_time)" +
            " values(#{name},#{introduction},#{create_user},#{bar_pic},now(),now())")
    void addBar(String name,String introduction,int create_user,String bar_pic);

    @Select("SELECT * FROM bar WHERE bar_id=#{id}")
    Bar findByBarId(int id);

    @Select("SELECT * FROM bar WHERE bar_name=#{barName}")
    Bar findByBarName(String barName);

    @Select("SELECT * FROM bar limit 20")
    public List<Bar> list();

}
