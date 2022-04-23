package com.zcy.fruitshop.exception;

public class ValidationException extends FSException{

    public ValidationException(String msg){
        super(msg);
    }

    public ValidationException(String msg, Throwable cause){
        super(msg, cause);
    }

}
