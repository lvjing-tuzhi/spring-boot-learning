package com.tuzhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: SpringBoot-Spring-Security
 * @description: 路由跳转
 * @author: 兔子
 * @create: 2021-12-26 09:26
 **/

@Controller
public class RouterController {

    @RequestMapping({"/","/index"})
    public String toIndex() {
        return "index";
    }

    @RequestMapping("login")
    public String toLogin() {
        return "views/login";
    }

    @RequestMapping("level1/{id}")
    public String toLevel1(@PathVariable("id") int id) {
        return "views/level1/"+id;
    }

    @RequestMapping("level2/{id}")
    public String toLevel2(@PathVariable("id") int id) {
        return "views/level2/"+id;
    }
    @RequestMapping("level3/{id}")
    public String toLevel3(@PathVariable("id") int id) {
        return "views/level3/"+id;
    }

}
