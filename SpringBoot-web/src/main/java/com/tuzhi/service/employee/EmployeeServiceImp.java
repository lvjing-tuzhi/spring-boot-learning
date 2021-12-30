package com.tuzhi.service.employee;

import com.tuzhi.mapper.DepartmentMapper;
import com.tuzhi.mapper.EmployeeMapper;
import com.tuzhi.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SpringBoot-web
 * @description:
 * @author: 兔子
 * @create: 2021-12-25 22:27
 **/


@Service
public class EmployeeServiceImp implements EmployeeService{

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeMapper.getEmployees();
        for (Employee employee : employees) {
            employee.setDepartment(departmentMapper.getDepartmentById(employee.getDid()));
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employeeById = employeeMapper.getEmployeeById(id);
        employeeById.setDepartment(departmentMapper.getDepartmentById(employeeById.getDid()));
        return employeeById;
    }

    @Override
    public int addEmployee(Employee employee) {
        return employeeMapper.addEmployee(employee);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }

    @Override
    public int deleteEmployee(int id) {
        return employeeMapper.deleteEmployee(id);
    }
}
