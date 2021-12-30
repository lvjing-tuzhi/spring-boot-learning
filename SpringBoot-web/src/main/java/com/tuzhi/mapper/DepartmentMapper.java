package com.tuzhi.mapper;

import com.tuzhi.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: SpringBoot-web
 * @description:
 * @author: 兔子
 * @create: 2021-12-25 20:58
 **/
@Mapper
@Repository
public interface DepartmentMapper {

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
    Department getDepartmentById(@Param("id") int id);

}
