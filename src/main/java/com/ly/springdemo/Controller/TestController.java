package com.ly.springdemo.Controller;

import com.ly.springdemo.Entity.DynamicTable;
import com.ly.springdemo.Mapper.DynamicMapping;
import com.ly.springdemo.Mapper.UserMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    UserMapping userMapping;
    @Autowired
    DynamicMapping dynamicMapping;

    @RequestMapping("/test")
    public String Test(){
        return userMapping.getNameById();
    }

    @RequestMapping("/DynamicTest")
    public int DynamicTest(DynamicTable dynamicTable){
        System.out.println(dynamicTable);
        return dynamicMapping.getIdByKey1AndKey2(dynamicTable);
    }
}
