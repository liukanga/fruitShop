package com.zcy.fruitshop.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Fruit {

    private Long id;
    private String name;

    /**
     *  类别
     */
    private String category;
    /**
     *  图片
     */
    private String imageUrls;
    /**
     *  产地
     */
    private String location;
    /**
     *  生产日期
     */
    private LocalDateTime dateOfManufacture;
    /**
     *  保质期
     */
    private String qualityGuaranteePeriod;
    /**
     *  价格
     */
    private String price;
    /**
     *  库存
     */
    private Integer stock;
    /**
     *  糖分
     */
    private String sugar;
    /**
     *  有机酸
     */
    private String organicAcid;
    /**
     *  糖酸比
     */
    private String sugarAcidRatio;
    /**
     *  维生素
     */
    private String vitamins;
    /**
     *  果肉质
     */
    private String meatQuality;
    /**
     *  水分
     */
    private String moisture;
    /**
     *  商家id
     */
    private String shopId;

    private LocalDateTime gmtCreated;
    private LocalDateTime gmtModified;

}
