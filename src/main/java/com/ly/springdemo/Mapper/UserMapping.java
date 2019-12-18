package com.ly.springdemo.Mapper;


import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapping {
    //@Select("select name from user where id = '1'")
    String getNameById();
}
