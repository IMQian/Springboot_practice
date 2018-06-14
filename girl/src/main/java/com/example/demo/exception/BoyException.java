package com.example.demo.exception;

import com.example.demo.enums.ResultEnum;

//不要继承Exception，RuntimeException继承于Exception,spring框架只对RuntimeException进行事物回滚
public class BoyException extends RuntimeException {
    private Integer code;

    public BoyException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
