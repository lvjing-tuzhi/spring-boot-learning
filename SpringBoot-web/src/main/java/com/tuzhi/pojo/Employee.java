package com.tuzhi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program: SpringBoot-web
 * @description: 员工类
 * @author: 兔子
 * @create: 2021-12-11 14:02
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String employeeName;
    private String email;
    private String gender;
    private String birth;
    private int did;
    private Department department;

}
