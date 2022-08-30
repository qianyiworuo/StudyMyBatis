package com.wd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
@Controller
public class HttpSessionTest {
    @RequestMapping("/session/test")
    public String test(HttpSession session){
        session.setAttribute("HttpsessionRequestTest","栓Q！");
        return "success";
    }
    @RequestMapping("/application/test")
    public String testApplacation(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("ApplicationRequestScopeTest","干嘛啊！");
        return "success";
    }
}
