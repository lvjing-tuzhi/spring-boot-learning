package com.tuzhi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: SpringBoot-shiro
 * @description: 用户实体类
 * @author: 兔子
 * @create: 2021-12-30 09:33
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String password;
}
