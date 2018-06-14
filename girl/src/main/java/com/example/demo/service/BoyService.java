package com.example.demo.service;

import com.example.demo.domain.Boy;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.BoyException;
import com.example.demo.repository.BoyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;


@Service
public class BoyService {

    @Autowired
    private BoyRepository boyRepository;


    public void getAge(Integer id) throws Exception {
        Boy boy = boyRepository.findById(id).get();
        Integer age = boy.getAge();
        if(age<10){
            //返回“你在上小学吧”
            throw new BoyException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>=10 && age<16){
            //返回“你可能在上初中吧”
            throw new BoyException(ResultEnum.MIDDLE_SCHOOL);
        }else{
            throw new BoyException(ResultEnum.FREEDOM);
        }
    }

    public Boy findOne(Integer id){
        return boyRepository.findById(id).get();
    }
}
