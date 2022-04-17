package com.zcy.fruitshop.service;

import com.zcy.fruitshop.bean.Comment;
import com.zcy.fruitshop.exception.FSDBException;

import java.util.List;

public interface CommentService {

    Comment loadCommentById(Long id);

    List<Comment> loadCommentByShopId(Long shopId);

    List<Comment> loadCommentByUserId(Long userId);

    Long addComment(Comment comment) throws FSDBException;

    int updateComment(Comment comment) throws FSDBException;

    int deleteCommentById(Long id);

}
