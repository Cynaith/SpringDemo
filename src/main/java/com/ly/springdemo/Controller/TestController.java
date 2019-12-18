package com.ly.springdemo.Controller;

import com.ly.springdemo.Mapper.UserMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    UserMapping userMapping;

    @RequestMapping("/test")
    public String Test(){
        return userMapping.getNameById();
    }
}
