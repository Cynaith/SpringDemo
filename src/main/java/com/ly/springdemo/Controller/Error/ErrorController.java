package com.ly.springdemo.Controller.Error;

import com.sun.deploy.net.HttpResponse;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//@Controller
//public class ErrorController extends AbstractErrorController {
//    public ErrorController() {
//        super(new DefaultErrorAttributes());
//    }
//    @RequestMapping("/error")
//    public String getErrorPath() {
//        //处理异常
//        return "error.html";
//    }
//}
