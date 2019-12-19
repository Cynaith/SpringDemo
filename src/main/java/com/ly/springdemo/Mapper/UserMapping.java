package com.ly.springdemo.Mapper;


import com.ly.springdemo.Entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapping {
    //@Select("select name from user where id = '1'")
    String getNameById();

    @Select("select * from user")
    List<User> findAll();
}
