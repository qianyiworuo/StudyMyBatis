package com.wd.mybatis.mapper;

import com.wd.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    User getUserById(@Param("id")Integer id);
    List<User> getAllUser();
    //查询用户总数量
    Integer getCount();
    Map<String, Object> getUserToMap(@Param("id")Integer id);
    List<Map<String, Object>> getAllUserToListMap();
}
