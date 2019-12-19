package com.ly.springdemo.Controller;

import com.ly.springdemo.Entity.DynamicTable;
import com.ly.springdemo.Mapper.DynamicMapping;
import com.ly.springdemo.Mapper.UserMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

    //@Cacheable(cacheNames = "dm",key = "#dynamicTable.key1")
    @RequestMapping("/DynamicTest/select")
    public int DynamicTest(DynamicTable dynamicTable){

        System.out.println(dynamicTable);
        return dynamicMapping.getIdByKey1AndKey2(dynamicTable);
    }
    @RequestMapping("/DynamicTest/insert")
    public int DynamicInsert(DynamicTable dynamicTable){
        System.out.println(dynamicTable);
        dynamicMapping.saveDynamic(dynamicTable);
        return dynamicTable.getId();
    }
}
