package com.example.simpleforumpro.mapper;

import com.example.simpleforumpro.pojo.Bar;
import com.example.simpleforumpro.pojo.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {

    @Select("select * from post where post_id=#{postId}")
    Post findByPostId(int postId);

    @Insert("insert into post(post_title,post_content,create_user,bar_id,create_time,update_time)" +
            " values(#{postTitle},#{postContent},#{createUser},#{barId},now(),now())")
    @Options(useGeneratedKeys = true,keyProperty = "postId",keyColumn = "postId")
    void add(Post post);

    @Delete("delete from post where post_id=#{postId}")
    void removeByPostId(int postId);

    @Select("SELECT * FROM post where bar_id=#{barId} limit 20")
    List<Post> listByBarId(int barId);
    @Select("SELECT * FROM post where create_user=#{userId} limit 20")
    List<Post> listByUserId(int userId);

    @Select("")
    int countPostNumberByUserId(int userId);

    @Select("SELECT COUNT(*) from post where bar_id=#{barId}")
    int countPostNumberByBarId(int barId);
}
