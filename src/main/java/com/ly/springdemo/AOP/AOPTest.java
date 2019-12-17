package com.ly.springdemo.AOP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


public class AOPTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(AspestsConfig.class);

        Calculator calculator = app.getBean(Calculator.class);
        int result = calculator.add(1,2);
        System.out.println(result);

        app.close();
    }
}

