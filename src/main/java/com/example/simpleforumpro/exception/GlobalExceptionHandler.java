package com.example.simpleforumpro.exception;

import com.example.simpleforumpro.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        e.printStackTrace();
        return Result.error((e.getMessage()!=null)?e.getMessage():"error");
    }
}
