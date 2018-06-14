package com.example.demo;

import com.example.demo.domain.Boy;
import com.example.demo.service.BoyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest //表示将启动整个spring工程
public class BoyServiceTest {

    @Autowired
    private BoyService boyService;

    @Test
    public void findOneTest(){
        Boy boy = boyService.findOne(3);
        Assert.assertEquals(new Integer(10),boy.getAge());
    }
}
