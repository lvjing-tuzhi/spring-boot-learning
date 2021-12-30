package com.tuzhi.dao;

import com.tuzhi.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: SpringBoot-web
 * @description:
 * @author: 兔子
 * @create: 2021-12-11 14:04
 **/

@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departmentMap = null;

    static {
        departmentMap = new HashMap<Integer, Department>();
        departmentMap.put(1, new Department(1, "市场部"));
        departmentMap.put(2, new Department(2, "研发部"));
    }

    //    获得部门所有信息
    public Collection<Department> getDepartments() {
        return departmentMap.values();
    }

    //    按ID获得部门
    public Department getDepartmentById(int id) {
        return departmentMap.get(id);
    }
}
