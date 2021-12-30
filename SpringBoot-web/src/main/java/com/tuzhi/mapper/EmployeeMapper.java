package com.tuzhi.mapper;

import com.tuzhi.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: SpringBoot-web
 * @description:员工表方法
 * @author: 兔子
 * @create: 2021-12-25 20:18
 **/

@Mapper
@Repository
public interface EmployeeMapper {

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
    Employee getEmployeeById(@Param("id") int id);

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
    int deleteEmployee(@Param("id") int id);

}
