package com.wd.mybatis.mapper;

import com.wd.mybatis.pojo.Emp;

import java.util.List;

public interface DynamicSQLMapper {
    //根据条件查询员工信息
    List<Emp> getEmpByCondition(Emp emp);
}
