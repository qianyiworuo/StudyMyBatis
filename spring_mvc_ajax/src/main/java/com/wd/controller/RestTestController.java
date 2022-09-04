package com.wd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 查询所有用户信息：/user--->get
 * 根据id查询所有用户信息：/user/1--->get
 * 添加用户信息：/user--->post
 * 修改用户信息：/user--->put
 * 删除用户信息：/user/1--->delete
 */
@Controller
public class RestTestController {
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUser(Model model){
        model.addAttribute("getAllUser","查询所有用户信息成功");
        return "success";
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUser(Model model, @PathVariable("id") Integer id){
        model.addAttribute("getUser","根据Id查询用户信息成功"+"id为："+ id);
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(Model model) {
        model.addAttribute("addUser", "新增成功");
        return "success";
    }
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updateUser(Model model){
        model.addAttribute("updateUser","修改成功");
        System.out.println("修改成功");
        return "success";
    }
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String deleteUser(Model model,@PathVariable("id") Integer id){
        model.addAttribute("deleteUser","删除成功，id为："+ id);
        System.out.println("删除成功"+"id为："+ id);
        return "success";
    }

}
