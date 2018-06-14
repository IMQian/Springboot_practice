package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
/*
    @Before("execution(public * com.example.demo.controller.BoyController.boyList(..))")
    public void log(){
        System.out.println(111111111);
    }
    @After("execution(public * com.example.demo.controller.BoyController.boyList(..))")
    public void lastLog(){
        System.out.println(222222222);
    }
    */
//代码改进1
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    //定义了一个切面，公用函数
    @Pointcut("execution(public * com.example.demo.controller.BoyController.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        //System.out.println(1111111111);
        logger.info("1111111");

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //请求的url
        logger.info("url={}",request.getRequestURL());

        //请求的方法
        logger.info("method={}",request.getMethod());
        //请求的ip
        logger.info("ip={}",request.getRemoteAddr());

        //请求的类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //请求的参数
        logger.info("args={}",joinPoint.getArgs());

    }

    @After("log()")
    public void doAfter(){
        //System.out.println(222222222);
        logger.info("2222222");
    }
//打印返回的内容
    @AfterReturning(returning = "object",pointcut="log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }


}
