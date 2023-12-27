package com.example.simpleforumpro.service;

import com.example.simpleforumpro.pojo.Post;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PostService {

    Post findPostByPostId(int postId);

    void add(Post post);
    void removeByPostId(int postId);

    List<Post> listByBarId(int barId);

    List<Post> listByUserId(int UserId);

    int countPostNumber(int type,int id);
}
