package com.example.simpleforumpro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//API接口返回的结果
@NoArgsConstructor
@AllArgsConstructor
@Data//必须加这个,才能让lombok自动生成setter和getter,以便生成json
public class Result<T>{
    private Integer code;
    private String message;
    private T data;
    public static <E> Result<E>success(E data){
        return new Result<>(0,"成功",data);
    }
    public static Result success(){
        return new Result(0,"操作成功",null);
    }

    public static Result error( String errorText) {
        return new Result(-1,errorText,null);
    }
}
