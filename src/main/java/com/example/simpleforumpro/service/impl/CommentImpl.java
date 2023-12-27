package com.example.simpleforumpro.service.impl;

import com.example.simpleforumpro.controller.PageBean;
import com.example.simpleforumpro.mapper.CommentMapper;
import com.example.simpleforumpro.pojo.Comment;
import com.example.simpleforumpro.service.CommentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public void add(Comment comment) {
        commentMapper.add(comment);
    }

    @Override
    public List<Comment> listCommentByPostId(int postId) {
        return commentMapper.listCommentByPostId(postId);
    }

    @Override
    public PageBean listCommentByPostId(int pageNum, int pageSize, int postId) {
        PageBean<Comment> pb = new PageBean<>();

        //有PageHelper后,会自动在sql后加limit
        PageHelper.startPage(pageNum,pageSize);

        //这里不能再调用之前的接口了,返回值不一样.
        List<Comment>commentList = commentMapper.listComment(postId);
        //Page中提供了方法,可以获取PageHelper分页查询后,得到的总记录条数和当前页数据
        Page<Comment> p = (Page<Comment>) commentList;
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }
}
