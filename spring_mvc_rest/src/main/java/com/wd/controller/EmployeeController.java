package com.wd.controller;

import com.wd.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * 查询全部数据√       /employee     GET
 * 删除√             /employee/2   DELETE
 * 跳转到添加数据页面√  /toAdd        GET
 * 执行保存√          /employee     POST
 * 跳转到更新数据页面√  /employee/2   GET
 * 执行更新√         /employee      PUT
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

}
