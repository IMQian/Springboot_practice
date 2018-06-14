package com.example.demo.exceptionhandle;

import com.example.demo.exception.BoyException;
import com.example.demo.resultformat.Result;
import com.example.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){//捕获Exception异常
        if(e instanceof BoyException){
            BoyException boyException = (BoyException) e;
            return ResultUtil.error(boyException.getCode(),boyException.getMessage());
        }else{
            logger.error("【系统异常】{}",e);
            return ResultUtil.error(-1,"未知错误");
        }

    }
}
