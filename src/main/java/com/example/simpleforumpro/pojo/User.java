package com.example.simpleforumpro.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class User {
    private Integer id;
    private String account;
    @JsonIgnore //Springmvc 转化json对象时,忽略password属性.
    private String password;
    private String nickname;
//    @JsonIgnore
    private LocalDateTime createTime;
//    @JsonIgnore
    private LocalDateTime updateTime;
}
