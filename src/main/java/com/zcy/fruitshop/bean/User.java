package com.zcy.fruitshop.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    private Long id;

    private String username;

    private String password;

    private LocalDateTime gmtCreated;

    private LocalDateTime gmtModified;

}
