package com.tuzhi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: SpringBoot-web
 * @description: 部门实体类
 * @author: 兔子
 * @create: 2021-12-11 14:00
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;
    public String departmentName;
}
