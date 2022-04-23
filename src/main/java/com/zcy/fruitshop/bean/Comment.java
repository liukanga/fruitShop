package com.zcy.fruitshop.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {

    private Long id;

    private String content;

    private Long shopId;

    private Long userId;

    private LocalDateTime gmtCreated;

    private LocalDateTime gmtModified;

}
