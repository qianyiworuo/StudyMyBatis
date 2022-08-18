package com.wd.spring.dao.impl;

import com.wd.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void getUser() {
        System.out.println("查询成功");
    }
}

