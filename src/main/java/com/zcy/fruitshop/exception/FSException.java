package com.zcy.fruitshop.exception;

public class FSException extends Exception{

    public FSException(String message){
        super(message);
    }

    public FSException(String message, Throwable cause){
        super(message, cause);
    }

}
