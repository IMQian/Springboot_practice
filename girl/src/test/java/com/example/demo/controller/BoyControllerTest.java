package com.example.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BoyControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void boyList() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/boys"))
                .andExpect(MockMvcResultMatchers.status().isOk())//返回的状态是否是200
                .andExpect(MockMvcResultMatchers.content().string("abc"));//希望返回的数值
    }
}