package com.tuzhi.service;

import com.tuzhi.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @program: SpringBoot-shiro
 * @description: 用户业务层
 * @author: 兔子
 * @create: 2021-12-30 09:41
 **/

public interface UserService {
    User queryUserByName(String name);
}
