package com.example.simpleforumpro.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class privilege {
    int privilegeId;
    int userId;
    int privilege_num;
}
