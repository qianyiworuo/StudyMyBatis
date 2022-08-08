package com.wd.mybatis.mapper;

import com.wd.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User getUserByUserName(String username);
    User checkLogin(String username, String password);
    User checkLoginByMap(Map<String, Object> map);
    int insertUser(User user);
    User checkLoginByParam(@Param("username")String username, @Param("password")String password);

}
