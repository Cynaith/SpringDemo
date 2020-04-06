package com.ly.springdemo.Config;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @USER: lynn
 * @DATE: 2020/4/7
 **/

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {

    /**
     * @ExceptionHandler里输入想要获取的异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String MethodArgumentNotValidEExceptionHandler(MethodArgumentNotValidException e){
        ObjectError error = e.getBindingResult().getAllErrors().get(0);
        return error.getDefaultMessage();
    }
}
