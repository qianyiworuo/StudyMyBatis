package com.wd.mybatis.mapper;

import com.wd.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {
    Emp getEmpById(@Param("empId") Integer empId);
}
