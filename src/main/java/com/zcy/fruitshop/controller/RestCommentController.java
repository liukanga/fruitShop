package com.zcy.fruitshop.controller;

import com.zcy.fruitshop.bean.Comment;
import com.zcy.fruitshop.bean.Result;
import com.zcy.fruitshop.bean.Shop;
import com.zcy.fruitshop.exception.FSDBException;
import com.zcy.fruitshop.exception.FSException;
import com.zcy.fruitshop.service.CommentService;
import com.zcy.fruitshop.util.FSConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Api(tags = "评论模块RestAPI")
@RestController
public class RestCommentController {

    @Autowired
    private CommentService commentService;

    @ApiOperation("查询评论")
    @GetMapping("/loadComment")
    public Result<List<Comment>> loadCommentById(@RequestParam(value = "id", required = false) Long id,
                                           @RequestParam(value = "shopId", required = false) Long shopId,
                                           @RequestParam(value = "userId", required = false) Long userId){
        Result<List<Comment>> result = new Result<>();
        result.setCode(200);
        result.setSuccess(true);

        List<Comment> comments = new ArrayList<>();

        if (id != null){
            Comment comment = commentService.loadCommentById(id);
            comments.add(comment);
        }
        if (userId != null){
            comments = commentService.loadCommentByUserId(userId);
        }
        if (shopId != null){
            comments = commentService.loadCommentByShopId(shopId);
        }
        result.setData(comments);
        result.setMessage(CollectionUtils.isEmpty(comments) ? FSConstant.NO_DATA_FOUND : FSConstant.SUCCESS);

        return result;
    }

    @ApiOperation("添加评论")
    @PostMapping("/addComment")
    public Result<Comment> addComment(@RequestBody Comment comment){
        Result<Comment> result = new Result<>();
        try {
            commentService.addComment(comment);
            result.setData(comment);
            result.setSuccess(true);
            result.setCode(200);
            result.setMessage("评论成功");
        }catch (FSDBException e){
            log.error("********* 添加评论失败", e);
            result.setSuccess(false);
            result.setCode(400);
            result.setMessage("评论失败，请重新尝试！");
        }
        return result;
    }

    @ApiOperation("修改评论")
    @PutMapping("/updateComment")
    public Result<Comment> updateComment(@RequestBody Comment comment) throws FSException {
        Result<Comment> result = new Result<>();
        try {
            commentService.updateComment(comment);
            result.setData(commentService.loadCommentById(comment.getId()));
            result.setSuccess(true);
            result.setCode(200);
            result.setMessage("修改评论成功");
            return result;
        }catch (FSDBException e){
            log.error("********* 修改评论失败", e);
            throw new  FSException("修改评论失败");
        }
    }


    @ApiOperation("根据id删除评论")
    @GetMapping("/deleteComment")
    public Result<String> deleteCommentById(@RequestParam("id") Long id){
        Result<String> result = new Result<>();
        commentService.deleteCommentById(id);
        result.setMessage("删除成功");
        result.setSuccess(true);
        return result;
    }

    @PostMapping("/allComment")
    public List<Comment> allComments(){

        return commentService.loadAllComment();
    }


}
