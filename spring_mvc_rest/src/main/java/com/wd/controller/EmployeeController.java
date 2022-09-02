package com.wd.controller;

import com.wd.dao.EmployeeDao;
import com.wd.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 *
 * 查询全部数据√        /employee      GET
 * 删除√               /employee/2    DELETE
 * 跳转到添加数据页面√  /toAdd         GET
 * 执行保存√           /employee      POST
 * 跳转到更新数据页面√  /employee/2    GET
 * 执行更新√           /employee      PUT
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("employees",employees);
        return "employee";
    }

}
