package com.example.demo.timedtask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TestTask {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //cron表达式的位数只能是6位，不支持年
    @Scheduled(cron = "5-20 * * * * ?")
    public void reportCurrentTime(){
        System.out.println("现在时间是："+dateFormat.format(new Date()));

    }
}
