package com.zcy.fruitshop.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Shop {

    private Long id;
    /**
     *  店名
     */
    private String name;
    /**
     *  地址
     */
    private String address;
    /**
     *  店主id
     */
    private Long userId;
    /**
     *  商家图片
     */
    private String imageUrls;
    /**
     *  许可证
     */
    private String permit;

    private String description;
    /**
     *  营业时间
     */
    private String bHours;

    private LocalDateTime gmtCreated;
    private LocalDateTime gmtModified;

    public Shop(String name, String address,  Long userId, String permit, String description, String bHours) {
        this.name = name;
        this.address = address;
        this.userId = userId;
        this.permit = permit;
        this.description = description;
        this.bHours = bHours;
    }

    public Shop(Long id, String name, String address, Long userId, String imageUrls, String permit, String description, String bHours, LocalDateTime gmtCreated, LocalDateTime gmtModified) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.userId = userId;
        this.imageUrls = imageUrls;
        this.permit = permit;
        this.description = description;
        this.bHours = bHours;
        this.gmtCreated = gmtCreated;
        this.gmtModified = gmtModified;
    }

    public Shop(){}
}
