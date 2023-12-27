package com.example.simpleforumpro.mapper;

import com.example.simpleforumpro.controller.PageBean;
import com.example.simpleforumpro.pojo.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Insert("insert into comment(create_user,post_id,comment_content,last_modified_time,create_time,update_time)" +
            " values(#{createUser},#{postId},#{commentContent},now(),now(),now())")
    void add(Comment comment);

    @Select("select * from comment where post_id=#{postId}")
    List<Comment> listCommentByPostId(int postId);
    @Select("select * from comment where post_id=#{postId}")
    List<Comment> listComment(int postId);
    //如果是动态参数的sql,需要使用映射配置文件

}
