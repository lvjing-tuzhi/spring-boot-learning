package com.tuzhi.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: SpringBoot-shiro
 * @description: 路由
 * @author: 兔子
 * @create: 2021-12-28 20:28
 **/

@Controller
public class RouterController {

    @RequestMapping({"/","/index"})
    public String index(Model model) {
        model.addAttribute("msg","HelloShiro");
        return "index";
    }

    @GetMapping("/user/add")
    public String add() {
        return "user/add";
    }

    @GetMapping("/user/update")
    public String update() {
        return "user/update";
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("进入登录界面");
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        System.out.println("======注销======");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "index";
    }

    @GetMapping("/unauthorized")
    @ResponseBody
    public String unauthorized() {
        return "对不起，您没有该权限";
    }
}
