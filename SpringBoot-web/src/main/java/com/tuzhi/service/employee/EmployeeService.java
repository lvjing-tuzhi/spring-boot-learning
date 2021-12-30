package com.tuzhi.service.employee;

import com.tuzhi.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: SpringBoot-web
 * @description:
 * @author: 兔子
 * @create: 2021-12-25 22:23
 **/

public interface EmployeeService {
    /**
     * 查询所有员工
     * @return
     */
    List<Employee> getEmployees();

    /**
     * 按id查询员工
     * @param id
     * @return
     */
    Employee getEmployeeById(int id);

    /**
     * 增加员工
     * @param employee
     * @return
     */
    int addEmployee(Employee employee);

    /**
     * 修改员工
     * @param employee
     * @return
     */
    int updateEmployee(Employee employee);

    /**
     * 按id删除员工
     * @param id
     * @return
     */
    int deleteEmployee(int id);
}
