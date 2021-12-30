package com.tuzhi.controller;

import com.tuzhi.mapper.DepartmentMapper;
import com.tuzhi.mapper.EmployeeMapper;
import com.tuzhi.pojo.Department;
import com.tuzhi.pojo.Employee;
import com.tuzhi.service.department.DepartmentSerivceImp;
import com.tuzhi.service.employee.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @program: SpringBoot-web
 * @description: 员工控制类
 * @author: 兔子
 * @create: 2021-12-20 21:36
 **/

@Controller
public class EmployeeController {
    @Autowired
    EmployeeServiceImp employeeServiceImp;
    @Autowired
    DepartmentSerivceImp departmentSerivceImp;

    @RequestMapping("/employee")
    public String list(Model model) {
        Collection<Employee> employees = employeeServiceImp.getEmployees();
        model.addAttribute("employees", employees);
        return "tables";
    }

    @GetMapping("/employeeOperate")
    public String toAddEmployee(Model model) {
        Collection<Department> departments = departmentSerivceImp.getDepartments();
        model.addAttribute("departments", departments);
        return "form-common";
    }

    @PostMapping("/employeeOperate")
    public String addEmployee(Employee employee) {
        System.out.println("========进入添加==========");
        System.out.println(employee);
        employeeServiceImp.addEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/employeeOperate/id/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        System.out.println("===================开始删除：==============" + id);
        employeeServiceImp.deleteEmployee(id);
        return "redirect:/employee";
    }

    @RequestMapping("employeeUpdate/id/{id}")
    public String toUpdateEmployee(@PathVariable("id") int id, Model model) {
        Employee employees = employeeServiceImp.getEmployeeById(id);
        model.addAttribute("employees", employees);
        Collection<Department> departments = departmentSerivceImp.getDepartments();
        model.addAttribute("departments", departments);
        return "form-common-update";
    }

    @PostMapping("employeeUpdate")
    public String updateEmployee(Employee employee) {
        employeeServiceImp.updateEmployee(employee);
        return "redirect:/employee";
    }


}
