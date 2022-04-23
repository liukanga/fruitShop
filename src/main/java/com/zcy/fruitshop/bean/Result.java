package com.zcy.fruitshop.bean;

import lombok.Data;

@Data
public class Result<T>{

    private int code;

    private String message;

    private boolean isSuccess;

    private T data;

}
