package com.tuzhi.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @program: SpringBoot-shiro
 * @description:用户业务类
 * @author: 兔子
 * @create: 2021-12-30 08:07
 **/

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(String username, String password, Model model) {
        System.out.println("进入登录验证"+"username: "+username+" password: "+password);
        Subject subject = SecurityUtils.getSubject();
//        把账号密码传入UserRealm中
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            return "index";
        }catch (UnknownAccountException e) {
            model.addAttribute("userMsg","用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e) {
            model.addAttribute("userMsg","密码错误");
            return "login";
        }
    }
}
