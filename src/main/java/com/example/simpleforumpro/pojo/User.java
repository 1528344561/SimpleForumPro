package com.example.simpleforumpro.pojo;

import lombok.Data;
import java.time.LocalDateTime;
@Data
public class User {
    private Integer id;
    private String account;
    private String password;
    private String nickname;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;


}
