package com.zcy.fruitshop.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Fruit {

    private Long id;

    private String name;

    private String variety;

    private LocalDateTime gmtCreated;

    private LocalDateTime gmtModified;

}
