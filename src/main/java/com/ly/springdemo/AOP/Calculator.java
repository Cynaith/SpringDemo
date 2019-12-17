package com.ly.springdemo.AOP;

import org.springframework.context.annotation.Bean;


public class Calculator {
    public Calculator() {
    }

    public int add(int a, int b){
        return a+b;
    }
}
