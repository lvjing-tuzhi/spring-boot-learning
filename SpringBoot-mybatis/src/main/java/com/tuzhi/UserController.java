package com.tuzhi;

import com.tuzhi.mapper.UserMapper;
import com.tuzhi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: SpringBoot-mybatis
 * @description:
 * @author: 兔子
 * @create: 2021-12-25 09:19
 **/

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("users")
    public List<User> queryUsers() {
        List<User> userList = userMapper.queryUsers();
        return userList;
    }

    @GetMapping("user")
    public User queryUserById() {
        User user = userMapper.queryUserById(1);
        return user;
    }

    @GetMapping("add")
    public int addUser() {
        int user = userMapper.addUser(new User(6, "SpringBoot", "admin"));
        return user;
    }

    @GetMapping("update")
    public int updateUser() {
        int user = userMapper.updataUser(new User(6, "SpringBoot", "root"));
        return user;
    }

    @GetMapping("delete")
    public int deleteUser() {
        int user = userMapper.deleteUser(6);
        return user;
    }
}
