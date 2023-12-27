package com.example.simpleforumpro.controller;

import com.example.simpleforumpro.pojo.Comment;
import com.example.simpleforumpro.pojo.Result;
import com.example.simpleforumpro.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @PostMapping("/add")
    Result add(@RequestBody Comment comment){
        commentService.add(comment);
        return Result.success("ok");
    }
    @GetMapping("/list")
    Result listCommentByPostId(
            @RequestParam(required = false)Integer pageNum,
            @RequestParam(required = false)Integer pageSize,
            int postId){

//        System.out.println(LocalDateTime.now());
        if(pageNum==null&&pageSize==null){
            List<Comment> commentList = commentService.listCommentByPostId(postId);
            return Result.success(commentList);
        }else{
            PageBean<Comment> pb =commentService.listCommentByPostId(pageNum,pageSize,postId);
            List<Comment> commentList = commentService.listCommentByPostId(postId);
            return Result.success(pb);
        }
    }
//    @GetMapping("/list")
//    Result listCommentByPostId(
//            Integer pageNum,
//            Integer pageSize,
//            /* @RequestParam(required = false) */ Integer postId){
//        PageBean<Comment> pb =commentService.listCommentByPostId(pageNum,pageSize,postId);
////        List<Comment> commentList = commentService.listCommentByPostId(postId);
//        return Result.success(pb);
//    }
}
