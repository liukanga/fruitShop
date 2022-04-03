package com.zcy.fruitshop.bean;

public enum MessageEnum {

    VERIFY_SUCCESS(600, "Success", "Verify user successfully"),
    VERIFY_FAILURE(601, "Failure", "Verify user failed");

    private int code;

    private String status;

    private String msg;

    MessageEnum(int code, String status, String msg){
        this.code = code;
        this.status = status;
        this.msg = msg;
    }

    public int getCode(){
        return this.code;
    }

    public String getStatus(){
        return this.status;
    }

    public String getMsg(){
        return this.msg;
    }

}
