package com.ly.springdemo.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ly.springdemo.Entity.DynamicTable;
import com.ly.springdemo.Entity.User;
import com.ly.springdemo.Mapper.DynamicMapping;
import com.ly.springdemo.Mapper.UserMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        return (int)dynamicMapping.getIdByKey1AndKey2(dynamicTable);
    }
    @RequestMapping("/DynamicTest/insert")
    public int DynamicInsert(DynamicTable dynamicTable){
        System.out.println(dynamicTable);
        dynamicMapping.saveDynamic(dynamicTable);
        return dynamicTable.getId();
    }

    @RequestMapping("/PageHelperTest")
    public PageInfo<User> getUserWithPagehelper(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<User> userList = userMapping.findAll();
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        return pageInfo;
    }
}
