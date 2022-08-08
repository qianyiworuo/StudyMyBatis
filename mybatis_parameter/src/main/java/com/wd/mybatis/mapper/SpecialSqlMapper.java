package com.wd.mybatis.mapper;

import com.wd.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSqlMapper {
    //模糊查询
    List<User> fuzzyQueryByUsername(@Param("info") String info);
}
