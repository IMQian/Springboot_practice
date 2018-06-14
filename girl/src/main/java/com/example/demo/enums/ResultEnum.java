package com.example.demo.enums;

public enum ResultEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"你还在上小学吧"),
    MIDDLE_SCHOOL(100,"你还在上小学吧"),
    FREEDOM(200,"你想干什么就干什么"),
    ;

    private Integer code;

    private String message;

    ResultEnum(int code, String message) {
        this.code=code;
        this.message=message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
