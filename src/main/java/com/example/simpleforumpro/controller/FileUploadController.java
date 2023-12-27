package com.example.simpleforumpro.controller;

import com.example.simpleforumpro.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws IOException {
        LocalDateTime localDateTime = LocalDateTime.now();
        String basePath =  "C:\\photos\\";
        String type = file.getContentType().split("/")[1];
//        String fileName = "C:\\photos\\"+localDateTime.toString().replace(':','-')+"."+type;
        String fileName =UUID.randomUUID().toString()+"."+type;
        file.transferTo(new File(basePath+fileName));
        return Result.success("/file/"+fileName);
    }
}
