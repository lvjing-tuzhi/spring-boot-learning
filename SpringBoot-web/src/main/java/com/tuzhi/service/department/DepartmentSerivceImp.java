package com.tuzhi.service.department;

import com.tuzhi.mapper.DepartmentMapper;
import com.tuzhi.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SpringBoot-web
 * @description:
 * @author: 兔子
 * @create: 2021-12-25 22:31
 **/

@Service
public class DepartmentSerivceImp implements DepartmentService{

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> getDepartments() {
        return departmentMapper.getDepartments();
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentMapper.getDepartmentById(id);
    }
}
