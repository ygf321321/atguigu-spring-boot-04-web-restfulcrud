package com.atguigu.springboot.controller;

import com.atguigu.springboot.dao.DepartmentDao;
import com.atguigu.springboot.dao.EmployeeDao;
import com.atguigu.springboot.entities.Department;
import com.atguigu.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    //员工列表页面
    @GetMapping("/emps")
    public String list(Model model){
       Collection<Employee> employees= employeeDao.getAll();
       model.addAttribute("emps",employees);
        //thymeleaf   classpath:/templates/xxx.html
        return "emp/list";
    }

    //员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //返回所有部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
    return "emp/add";
    }
}
