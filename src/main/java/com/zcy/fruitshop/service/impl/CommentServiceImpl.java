package com.zcy.fruitshop.service.impl;

import com.zcy.fruitshop.bean.Comment;
import com.zcy.fruitshop.dao.CommentDao;
import com.zcy.fruitshop.exception.FSDBException;
import com.zcy.fruitshop.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public Comment loadCommentById(Long id) {
        return commentDao.loadCommentById(id);
    }

    @Override
    public List<Comment> loadCommentByShopId(Long shopId) {
        return commentDao.loadCommentByShopId(shopId);
    }

    @Override
    public List<Comment> loadCommentByUserId(Long userId) {
        return commentDao.loadCommentByUserId(userId);
    }

    @Override
    public Long addComment(Comment comment) throws FSDBException {
        try {
            return commentDao.addComment(comment);
        }catch (Exception e){
            log.error("********* 添加评论失败", e);
            throw new FSDBException("添加评论到数据库失败");
        }
    }

    @Override
    public int updateComment(Comment comment) throws FSDBException {
        try {
            commentDao.updateComment(comment);
            return 0;
        }catch (Exception e){
            log.error("********* 更新评论失败", e);
            throw new FSDBException("更新评论到数据库失败");
        }
    }

    @Override
    public int deleteCommentById(Long id) {
        commentDao.deleteById(id);
        return 0;
    }

    @Override
    public List<Comment> loadAllComment() {
        return commentDao.loadAllComment();
    }

    @Override
    public List<Comment> getCommentByShopId(Long id) {
        return commentDao.getCommentByShopId(id);
    }
}
