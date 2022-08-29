package com.wd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ModelAndViewTest {
    @RequestMapping("/modelandview/test")
    public ModelAndView test(){
        /**
         * ModelAndView有Model和View的功能
         * Model主要用于向请求域共享数据
         * View主要用于设置视图，实现页面跳转
         */
        ModelAndView mav = new ModelAndView();
        //向请求域共享数据
        mav.addObject("modelandviewrequestscope","Are you OK?");
        //设置视图，实现页面跳转
        mav.setViewName("success");
        return mav;
    }
    @RequestMapping("/model/test")
    public String ModelTest(Model model){
        model.addAttribute("modeltest","Fan Thank You!");
        return "success";
    }

    @RequestMapping("/modelmap/test")
    public String ModelMapTest(ModelMap modelMap){
        modelMap.addAttribute("modelmaptest","How are you!");
        return "success";
    }
    @RequestMapping("/map/test")
    public String ModelMapTest(Map<String, Object> map){
        map.put("maptest","What are you doing");
        return "success";
    }
}
