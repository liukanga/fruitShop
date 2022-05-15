package com.zcy.fruitshop.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    private Long accountNumber;

    private String username;

    private String password;

    private String address;

    private String level;

    private String imageUrls;

    private String description;

    private String contract;

    private String accessCode;

    private LocalDateTime gmtCreated;

    private LocalDateTime gmtModified;

    public User(String username, String password, String address, String level, String description, String contract) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.level = level;
        this.description = description;
        this.contract = contract;
    }

    public User() {
    }
}
