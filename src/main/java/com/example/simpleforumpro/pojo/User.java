package com.example.simpleforumpro.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class User {
    @NotNull
    private Integer id;
    private String account;
    @JsonIgnore //Springmvc 转化json对象时,忽略password属性.
    private String password;
    @NotEmpty
    private String nickname;
//    @JsonIgnore
    private LocalDateTime createTime;
//    @JsonIgnore
    private LocalDateTime updateTime;
}
