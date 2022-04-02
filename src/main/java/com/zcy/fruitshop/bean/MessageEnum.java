package com.zcy.fruitshop.bean;

public enum MessageEnum {

    VERIFY_SUCCESS(600, "Success", "Verify user successfully"),
    VERIFY_FAILURE(601, "Failure", "Verify user failed");

    MessageEnum(int code, String status, String statusMsg){}

}
