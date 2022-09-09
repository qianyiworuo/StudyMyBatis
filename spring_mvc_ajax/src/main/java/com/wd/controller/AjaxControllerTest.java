package com.wd.controller;


import com.wd.pojo.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
    @RequestMapping("/responseBody/returnjson/test")
    @ResponseBody
    public User ResponseBodyReturnJsonTest() throws IOException {
        User user = new User(1001, "ljc", "123qwe", 22, 0);
        return user;
    }

    @RequestMapping("/test/down")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/static/img/1.jpg");
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=Subnautica.jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }
}
