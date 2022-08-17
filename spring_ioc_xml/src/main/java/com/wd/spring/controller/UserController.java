package com.wd.spring.controller;

import com.wd.spring.service.UserService;

public class UserController {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public void getUser(){
        userService.getUser();
    }
}
