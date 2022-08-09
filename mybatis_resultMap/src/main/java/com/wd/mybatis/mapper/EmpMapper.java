package com.wd.mybatis.mapper;

import com.wd.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    List<Emp> getAllEmp();
    //获取员工以及对应的部门信息
    Emp getEmpAndDeptByEmpId(@Param("empId")Integer empId);

}
