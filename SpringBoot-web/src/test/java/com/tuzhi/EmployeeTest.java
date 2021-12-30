package com.tuzhi;

import com.tuzhi.mapper.EmployeeMapper;
import com.tuzhi.pojo.Employee;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: SpringBoot-web
 * @description:
 * @author: 兔子
 * @create: 2021-12-25 20:57
 **/
@SpringBootTest
public class EmployeeTest {

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    void getemployees() {
        Employee employeeById = employeeMapper.getEmployeeById(1);
        System.out.println(employeeById);
    }
    @Test
    void addEmployee() {
        int ces = employeeMapper.addEmployee(new Employee(null, "ces", "542918093@qq", "1", "2021-12-12", 0,null));
        System.out.println(ces);
    }
    @Test
    void updateEmployee() {
        int ces = employeeMapper.updateEmployee(new Employee(3, "ces", "542918093@qq", "1", "2021-12-12", 0,null));
        System.out.println(ces);
    }
    @Test
    void deleteEmployee() {
        int i = employeeMapper.deleteEmployee(3);
        System.out.println(i);
    }
}
