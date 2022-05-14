package com.zcy.fruitshop.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentUser extends Comment{

    private String username;

    public CommentUser(String content, LocalDateTime gmtCreated, String username) {
        super(content, gmtCreated);
        this.username = username;
    }

    public CommentUser(){}
}
