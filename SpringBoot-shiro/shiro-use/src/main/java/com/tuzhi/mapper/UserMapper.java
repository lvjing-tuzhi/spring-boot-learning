package com.tuzhi.mapper;

import com.tuzhi.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: SpringBoot-shiro
 * @description: 用户dao层接口
 * @author: 兔子
 * @create: 2021-12-30 09:35
 **/

@Mapper
@Repository
public interface UserMapper {
    User queryUserByName(@Param("name") String name);
}
