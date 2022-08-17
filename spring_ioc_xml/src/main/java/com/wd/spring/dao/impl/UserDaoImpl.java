package com.wd.spring.dao.impl;

import com.wd.spring.dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public void getUser() {
        System.out.println("查询成功");
    }
}
