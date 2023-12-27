package com.example.simpleforumpro.service.impl;

import com.example.simpleforumpro.mapper.BarMapper;
import com.example.simpleforumpro.mapper.PostMapper;
import com.example.simpleforumpro.pojo.Post;
import com.example.simpleforumpro.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;
    @Override
    public Post findPostByPostId(int postId) {
        Post post = postMapper.findByPostId(postId);
        return post;
    }

    @Override
    public void add(Post post) {
        postMapper.add(post);
    }

    @Override
    public void removeByPostId(int postId) {
        postMapper.removeByPostId(postId);
    }

    @Override
    public List<Post> listByBarId(int barId) {
//        return null;
        List<Post> postList = postMapper.listByBarId(barId);
        return postList;
    }

    @Override
    public List<Post> listByUserId(int UserId) {
        List<Post> postList = postMapper.listByUserId(UserId);
        return postList;
    }

    @Override
    public int countPostNumber(int type, int id) {
        if(type==0){
            return postMapper.countPostNumberByUserId(id);
        }else{
            return postMapper.countPostNumberByBarId(id);
        }
    }
}
