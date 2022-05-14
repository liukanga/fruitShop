package com.zcy.fruitshop.bean;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FruitOrder {

    private Long id;

    private String fName;

    private double price;

    private Integer stock;

    private Long userId;

    private Long shopId;

    private String username;

    private String address;

    private String contract;

    private LocalDate gmtCreated;

    private LocalDate gmtModified;

}
