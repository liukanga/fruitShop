package com.zcy.fruitshop.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    private Long accountNumber;

    private String username;

    private String password;

    private String address;

    private int level;

    private String imageUrls;

    private String description;

    private String contract;

    private LocalDateTime gmtCreated;

    private LocalDateTime gmtModified;

}
