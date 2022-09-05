package com.wd.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AjaxControllerTest {
    @RequestMapping("/ajax/test")
    public void ajaxTest(Integer id, @RequestBody String reqBody  ,HttpServletResponse response) throws IOException {
        System.out.println("id："+id);
        System.out.println("reqBody："+ reqBody);
        response.getWriter().write("栓Q");
    }
}
