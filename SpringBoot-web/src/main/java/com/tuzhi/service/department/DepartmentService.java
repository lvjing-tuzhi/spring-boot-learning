package com.tuzhi.service.department;

import com.tuzhi.pojo.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: SpringBoot-web
 * @description:
 * @author: 兔子
 * @create: 2021-12-25 22:30
 **/

public interface DepartmentService {
    /**
     * 查询所有部门
     * @return
     */
    List<Department> getDepartments();

    /**
     * 按id查找部门
     * @param id
     * @return
     */
    Department getDepartmentById(int id);
}
