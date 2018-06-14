package com.example.demo.controller;

import com.example.demo.domain.Boy;
import com.example.demo.repository.BoyRepository;
import com.example.demo.resultformat.Result;
import com.example.demo.service.BoyService;
import com.example.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class BoyController {
    @Autowired
    public BoyRepository boyRepository;
    @Autowired
    public BoyService boyService;

    /**
     * 获取所有的男生列表
     * @return
     */
    @GetMapping(value = "/boys")
    public Iterable<Boy> boyList(){
        return boyRepository.findAll();
    }

    /**
     * 插入一个男生的数据
     * @return
     */
    @Transactional
    @PostMapping(value = "/boys")
    /*
    public Boy boy(@RequestParam("name") String name,
                   @RequestParam("age") Integer age){ */
    //换种方式写入数据,把单个属性换成对象
    public Result<Boy> boy(@Valid Boy boy, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        boy.setName(boy.getName());
        boy.setAge(boy.getAge());

        return ResultUtil.success(boyRepository.save(boy));
    }

    /**
     * 通过id查询一个男生
     * @param id
     * @return
     */
    @GetMapping(value = "/boys/{id}")
    public Boy findOneBoy(@PathVariable("id") Integer id){
        return boyRepository.findById(id).get();
    }
    //更新一个女生
    @PutMapping(value = "/boys/{id}")
    public Boy boyUpdate(@PathVariable("id") Integer id,
                            @RequestParam("name") String name,
                            @RequestParam("age") Integer age){
        Boy boy = new Boy();
        boy.setId(id);
        boy.setName(name);
        boy.setAge(age);
        return boyRepository.save(boy);
    }
    //删除一个女生
    @DeleteMapping(value = "/boys/{id}")
    public void boyDelete(@PathVariable("id") Integer id){
        boyRepository.deleteById(id);
    }
    //通过年龄查询
    @GetMapping(value = "/boys/age/{age}")
    public List<Boy> boyListAge(@PathVariable("age") Integer age){
        return boyRepository.findByAge(age);
    }

    @GetMapping(value="/boys/name/{name}")
    public List<Boy> boyListName(@PathVariable("name") String name){
        return boyRepository.findByName(name);
    }

    @GetMapping(value = "/boys/get_age/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        boyService.getAge(id);
    }
}
