package com.tuzhi.controller;

import com.tuzhi.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @program: SpringBoot-Swagger
 * @description:
 * @author: 兔子
 * @create: 2021-12-30 21:53
 **/

@RestController
@Api(tags = {"用户接口"})
public class HelloController {

    @GetMapping("/hello/{nameHello}/{author}")
    @ApiOperation("hello")

    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "nameHello", value = "你要Hello的内容",dataType = "String"),
            @ApiImplicitParam(name = "author", value = "作者名",dataType = "int")
    })
    public String hello(String nameHello,int author) {
        return "hello" + nameHello + author;
    }

    @PostMapping("/add")
    @ApiOperation("添加用户")
    public User add(User user) {

        return user;
    }

}
