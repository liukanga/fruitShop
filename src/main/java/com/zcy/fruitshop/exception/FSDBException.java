package com.zcy.fruitshop.exception;

public class FSDBException extends FSException{

    public FSDBException(String message) {
        super(message);
    }

    public FSDBException(String message, Throwable cause) {
        super(message, cause);
    }
}
