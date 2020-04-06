package com.ly.springdemo.Controller;

import com.ly.springdemo.Entity.ApiLearn;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @USER: lynn
 * @DATE: 2020/4/7
 **/


@RestController
@RequestMapping("valid")
public class ApiController {

    /**
     *
     * @param apiLearn
     * @param bindingResult
     * @return Validator + BindResult方式
     */
    @RequestMapping("validOutput")
    public String validApiLearn(@RequestBody @Valid ApiLearn apiLearn, BindingResult bindingResult){
        for (ObjectError error:bindingResult.getAllErrors()){
            return error.getDefaultMessage();
        }
        return apiLearn.toString();
    }

    /**
     *
     * @param apiLearn
     * @return Validator + 全局异常处理
     */
    @RequestMapping("validException")
    public String validException(@RequestBody @Valid ApiLearn apiLearn){
        return apiLearn.toString();
    }
}
