package com.tuzhi;

import com.tuzhi.dao.DepartmentDao;
import com.tuzhi.mapper.EmployeeMapper;
import com.tuzhi.pojo.Department;
import com.tuzhi.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@SpringBootTest
class SpringBootWebApplicationTests {

    @Autowired
    DataSource dataSource;
    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    void contextLoads() throws SQLException {
        List<Employee> employees = employeeMapper.getEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println(dataSource.getConnection());
    }


}
