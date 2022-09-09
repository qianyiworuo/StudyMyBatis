package com.wd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionHandlerTest {
    @RequestMapping("/exception/handler")
    public String ExceptionHandlerTest(){
        System.out.println(1/0);
        return "success";
    }
}
