package com.wd.mybatis.mapper;

import com.wd.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSqlMapper {
    //模糊查询
    List<User> fuzzyQueryByUsername(@Param("info") String info);
    //批量删除
    int deleteBatchUser(@Param("ids")String ids);
    //动态设置表名
    List<User> getAllUser(@Param("tableName")String tableName);
    //添加用户信息并获取自增主键
    void insertUser(User user);
}
