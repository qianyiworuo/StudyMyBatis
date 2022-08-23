package com.wd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {
    @RequestMapping("/")
    public String protal(){
        //讲逻辑视图返回
        return"index";
    }
    @RequestMapping("/test")
    public String test(){
        return "success";
    }
//    @RequestMapping("/hello")
//    public String hello(){
//        return "success";
//    }

}
