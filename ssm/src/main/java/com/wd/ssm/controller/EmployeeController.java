package com.wd.ssm.controller;

import com.wd.ssm.pojo.Employee;
import com.wd.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 *查询全部数据√         /employee      GET
 *根据id获取数据√       /employee/1    GET
 *删除√               /employee/2    DELETE
 *跳转到添加数据页面√    /toAdd         GET
 *执行保存√            /employee      POST
 * 跳转到更新数据页面√   /employee/2    GET
 * 执行更新√           /employee      PUT
 * */

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        List<Employee> employeeList = employeeService.getAllEmployee();
        model.addAttribute("list",employeeList);
        return "employee_index";
    }
}
