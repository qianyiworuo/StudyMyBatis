package com.wd.ssm.service.impl;

import com.wd.ssm.mapper.EmployeeMapper;
import com.wd.ssm.pojo.Employee;
import com.wd.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = employeeMapper.getEmployeeList();
        return employeeList;

    }
}
