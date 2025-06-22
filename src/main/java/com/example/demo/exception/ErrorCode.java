package com.example.demo.exception;

public enum ErrorCode {
    USER_EXISTED(1001,"User already existed"),
    USERNAME_INVALID(1002,"Username must be at least 3 characters"),
    IVALID_PASSWORD(1003,"Password must be at least 8 characters"),
    ;
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
