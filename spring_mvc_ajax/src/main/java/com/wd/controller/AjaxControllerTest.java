package com.wd.controller;


import com.wd.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class AjaxControllerTest {
    @RequestMapping("/ajax/test")
    public void ajaxTest(Integer id, @RequestBody String reqBody  ,HttpServletResponse response) throws IOException {
        System.out.println("id："+id);
        System.out.println("reqBody："+ reqBody);
        response.getWriter().write("栓Q");
    }
    //@RequestMapping("/axios/requestbody/test")
    public void AxiosRequestBodyTest(HttpServletResponse resp, @RequestBody User user) throws IOException {
        System.out.println("用户："+ user);
        resp.getWriter().write(user.toString());

    }
    @RequestMapping("/axios/requestbody/test")
    public void AxiosRequestBodyToMapTest(HttpServletResponse resp, @RequestBody Map<String,Object> map) throws IOException {
        System.out.println("用户："+ map);
        resp.getWriter().write(map.values().toString());

    }

}
