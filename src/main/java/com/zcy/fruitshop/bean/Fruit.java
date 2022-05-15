package com.zcy.fruitshop.bean;

import lombok.Data;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    private LocalDate dateOfManufacture;
    /**
     *  保质期
     */
    private String qualityGuaranteePeriod;
    /**
     *  价格
     */
    private double price;
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
    private Long shopId;

    private LocalDate gmtCreated;
    private LocalDate gmtModified;

    public Fruit(String name, String category, String location, String dateOfManufacture, String qualityGuaranteePeriod, double price, Integer stock, String sugar, String organicAcid, String sugarAcidRatio, String vitamins, String meatQuality, String moisture, Long shopId) {
        this.name = name;
        this.category = category;
        this.location = location;
        if (StringUtils.hasText(dateOfManufacture)){
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.dateOfManufacture = LocalDate.parse(dateOfManufacture, fmt);
        }
        this.qualityGuaranteePeriod = qualityGuaranteePeriod;
        this.price = price;
        this.stock = stock;
        this.sugar = sugar;
        this.organicAcid = organicAcid;
        this.sugarAcidRatio = sugarAcidRatio;
        this.vitamins = vitamins;
        this.meatQuality = meatQuality;
        this.moisture = moisture;
        this.shopId = shopId;
    }



    public Fruit(){}
}
