package com.example.simpleforumpro.controller;


import com.example.simpleforumpro.pojo.Comment;
import com.example.simpleforumpro.pojo.Post;
import com.example.simpleforumpro.pojo.Result;
import com.example.simpleforumpro.service.CommentService;
import com.example.simpleforumpro.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;
    @PostMapping("/add")
    Result add(@RequestBody @Validated Post post) {
        postService.add(post);
        Comment comment = new Comment();
        comment.setCreateUser(post.getCreateUser());
        comment.setPostId(post.getPostId());
        comment.setCommentContent(post.getPostContent());
        commentService.add(comment);
        return Result.success("创建成功");
    }

    @GetMapping("/list")
    Result listByBarOrUserID(int type,int Id) {
        List<Post> postList;
        if(type==0)
            postList = postService.listByBarId(Id);
        else
            postList  =postService.listByUserId(Id);
//        return postList;
        System.out.println(type);
        return Result.success(postList);

    }
    @GetMapping("/postInfo")
    Result findByPostId(int postId){
        Post post = postService.findPostByPostId(postId);
        if(post==null){
            return Result.error("贴子不存在");
        }else{
            return Result.success(post);
        }
    }
    @GetMapping("/postNumber")
    Result findPostNumber(int type,int id){
        int postNumber = postService.countPostNumber(type,id);
        return Result.success(postNumber);
    }
}
