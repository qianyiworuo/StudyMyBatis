package com.wd.spring.service.impl;

import com.wd.spring.dao.UserDao;
import com.wd.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public void getUser() {
        userDao.getUser();
    }
}
