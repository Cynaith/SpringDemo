package com.ly.springdemo.Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String toString() {
       return  userDao.toString();
    }

    public static void main(String[] args){
        ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserService userService = (UserService) factory.getBean("userService");
        System.out.println(userService.toString());
    }
}
