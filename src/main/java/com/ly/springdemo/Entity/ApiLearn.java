package com.ly.springdemo.Entity;

import org.springframework.validation.ValidationUtils;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @USER: lynn
 * @DATE: 2020/4/7
 * @NotEmpty：不能为null，且size>0
 * @NotNull：不能为null，但可以为empty，没有size的约束
 * @NotBlank：只用于String，不能为null，且trim()后size>0
 * 注：trim()方法使String去掉两端空格
 **/
public class ApiLearn {
    @NotNull(message = "id不能为空")
    private int id;

    @NotNull(message = "账号不能为空")
    @Size(min = 6,max = 12,message = "账号长度必须是6-12个字符")
    private String account;

    @NotNull(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String mail;

    @Max(value = 120,message = "年龄必须小于120")
    private int age;

    @AssertTrue(message = "字段为true才能通过")
    private boolean isPass;

    @Future(message = "时间在当前时间之后才可以通过")
    private Date futureDate;

    @Past(message = "时间在当前时间之前才可以通过")
    private Date passDate;

}
