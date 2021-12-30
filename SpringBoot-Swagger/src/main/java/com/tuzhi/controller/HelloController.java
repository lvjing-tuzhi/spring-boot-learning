package com.tuzhi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringBoot-Swagger
 * @description:
 * @author: 兔子
 * @create: 2021-12-30 21:53
 **/

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
