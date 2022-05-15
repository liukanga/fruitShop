package com.zcy.fruitshop.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShopUser extends Shop{

    private String username;

    private String contract;

    public ShopUser(Long id, String name, String address, Long userId, String imageUrls, String permit, String description, String bHours, LocalDateTime gmtCreated, LocalDateTime gmtModified) {
        super(id, name, address, userId, imageUrls, permit, description, bHours, gmtCreated, gmtModified);
    }

    public ShopUser(){}
}
