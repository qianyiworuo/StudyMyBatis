package com.wd.controller;

import com.wd.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
@Controller
public class ParamControllerTest {
    @RequestMapping("/param/servletapi")
    public String ServletAPITest(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("用户名："+username+"，密码："+password);
        return "success";
    }
    @RequestMapping("/param")
    public String ParamTest(@RequestParam(value = "userName",required = true, defaultValue = "user") String username, String password){
        System.out.println("用户名："+username+"，密码："+password);
        return "success";
    }
    @RequestMapping("/param/pojo")
    public String ParamPojoTest(User user){
        System.out.println(user);
        return "success";
    }

}
