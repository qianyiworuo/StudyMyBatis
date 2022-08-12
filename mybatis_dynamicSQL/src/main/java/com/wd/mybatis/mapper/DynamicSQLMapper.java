package com.wd.mybatis.mapper;

import com.wd.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {
    //根据条件查询员工信息
    List<Emp> getEmpByCondition(Emp emp);
    //批量插入员工信息
    void insertBatchEmp(@Param("emps") List<Emp> emps);
    //批量删除员工信息
    void deleteBatchEmp(@Param("empIds") Integer[] empIds);
}
