package com.example.simpleforumpro.service;

import com.example.simpleforumpro.controller.PageBean;
import com.example.simpleforumpro.pojo.Comment;

import java.util.List;

public interface CommentService {
    public void add(Comment comment);

    public List<Comment> listCommentByPostId(int postId);

    //分页
    public PageBean listCommentByPostId(int pageNum, int pageSize, int postId);

}
