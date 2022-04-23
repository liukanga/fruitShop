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
    private String userId;
    /**
     *  商家图片
     */
    private String imageUrls;
    /**
     *  许可证
     */
    private String permit;
    /**
     *  营业时间
     */
    private String bHours;

    private LocalDateTime gmtCreated;
    private LocalDateTime gmtModified;

}
