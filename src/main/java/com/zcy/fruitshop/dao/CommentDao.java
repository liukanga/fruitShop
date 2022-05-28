package com.zcy.fruitshop.dao;

import com.zcy.fruitshop.bean.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentDao {

    Comment loadCommentById(@Param("id") Long id);

    List<Comment> loadCommentByShopId(@Param("shopId") Long shopId);

    List<Comment> loadCommentByUserId(@Param("userId") Long userId);

    Long addComment(Comment comment);

    void updateComment(Comment comment);

    void deleteById(@Param("id") Long id);

    List<Comment> loadAllComment();

    List<Comment> getCommentByShopId(Long id);
}
