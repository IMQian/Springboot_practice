package com.example.demo.controller;

import com.example.demo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value={"/hello"},method = RequestMethod.GET)
    //@GetMapping(value= "/hello")
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myId){
        return girlProperties.getCupSize()+" id="+myId;
    }

}
