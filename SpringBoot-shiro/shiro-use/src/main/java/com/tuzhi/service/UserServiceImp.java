package com.tuzhi.service;

import com.tuzhi.mapper.UserMapper;
import com.tuzhi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: SpringBoot-shiro
 * @description: 用户业务实现类
 * @author: 兔子
 * @create: 2021-12-30 09:48
 **/

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }
}
