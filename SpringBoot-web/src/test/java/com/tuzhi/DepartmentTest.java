package com.tuzhi;

import com.tuzhi.mapper.DepartmentMapper;
import com.tuzhi.pojo.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @program: SpringBoot-web
 * @description:
 * @author: 兔子
 * @create: 2021-12-25 21:03
 **/

@SpringBootTest
public class DepartmentTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Test
    void getDepartments() {
        List<Department> departments = departmentMapper.getDepartments();
        for (Department department : departments) {
            System.out.println(department);
        }
    }
    @Test
    void getDepartmentById() {
        Department departmentById = departmentMapper.getDepartmentById(1);
        System.out.println(departmentById);
    }


}
