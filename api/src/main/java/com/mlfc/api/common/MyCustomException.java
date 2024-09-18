package com.mlfc.api.common;

public class MyCustomException extends RuntimeException {
    public MyCustomException(String message) {
        super(message);
    }
}
