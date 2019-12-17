package com.ly.springdemo.AOP;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//开启AOp模式
@EnableAspectJAutoProxy
public class AspestsConfig {
    @Bean
    public Calculator calculator(){
        return new Calculator();
    }
    @Bean
    public CalculatorAspests calculatorAspests(){
        return new CalculatorAspests();
    }
}
