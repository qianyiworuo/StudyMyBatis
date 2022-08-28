package com.wd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class RequestMappingTestController {
    //此时控制器方法所匹配的请求路径为/test/requestMappingTest
    @RequestMapping(value = {"/requestMappingTest", "/abc","/method"}
    ,method = {RequestMethod.POST, RequestMethod.GET})
    public String test(){
        return "success";
    }
    @RequestMapping("/a?a/ant")
    public String testAnt(){
        return "success";
    }
    @RequestMapping("/rest/{username}/{id}")
    public String testRest(@PathVariable("id") Integer id, @PathVariable("username") String username){
        System.out.println("id的值："+id);
        System.out.println("username值："+ username);
        return "success";
    }


}
