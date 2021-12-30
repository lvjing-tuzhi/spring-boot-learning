package com.tuzhi.mapper;

import com.tuzhi.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: SpringBoot-mybatis
 * @description:
 * @author: 兔子
 * @create: 2021-12-25 09:06
 **/

@Mapper
@Repository
public interface UserMapper {

    List<User> queryUsers();

    User queryUserById(@Param("id") int id);

    int addUser(User user);

    int updataUser(User user);

    int deleteUser(@Param("id") int id);

}
