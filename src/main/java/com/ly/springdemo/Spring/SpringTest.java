package com.ly.springdemo.Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        SetComplexType setComplexType = (SetComplexType)applicationContext.getBean("setComplexType");
        System.out.println(setComplexType.toString());
    }
}
