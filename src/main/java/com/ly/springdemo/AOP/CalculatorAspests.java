package com.ly.springdemo.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class CalculatorAspests {

    @Pointcut("execution(public int com.ly.springdemo.AOP.Calculator.*(..))")
    public void pointCut(){};

    @Before("pointCut()")
    public void LogStart(JoinPoint joinPoint){
        System.out.println("@Before: 方法名"+joinPoint.getSignature().getName());
        System.out.println("@Before: 参数列表:"+ Arrays.toString(joinPoint.getArgs()));
    }

    @After("pointCut()")
    public void LogEnd(JoinPoint joinPoint){
        System.out.println("@After: 方法名"+joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "pointCut()",returning = "result")
    public void LogReturn(Object result){
        System.out.println("@AfterReturning: 返回的值为"+result);
    }
    @AfterThrowing(value="pointCut()",throwing="exception")
    public void LogException(Exception exception){
        System.out.println("@AfterThrowing: 运行异常为 "+exception);
    }

    @Around("pointCut()")
    public Object AroundLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("@Around 环绕Log");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("@Around 环绕Log");
        return object;
    }

}
