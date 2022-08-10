package com.wd.mybatis.mapper;

import com.wd.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    //分步查询员工信息以及对应部门信息2
    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);
    //获取部门信息以及对应员工的信息(一对多)
    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);
    //分步获取部门信息以及对应员工的信息1(一对多)
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);
}
