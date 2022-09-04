package com.wd.controller;

import com.wd.dao.EmployeeDao;
import com.wd.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        employeeDao.saveOrUpdate(employee);
        return "redirect:/employee";
    }
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String getUser(Model model, @PathVariable("id") Integer id){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        return "employee_update";
    }
    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String updateUser(Employee employee){
        employeeDao.saveOrUpdate(employee);
        return "redirect:/employee";
    }
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }
}
