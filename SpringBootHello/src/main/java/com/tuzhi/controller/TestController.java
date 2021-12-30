package com.tuzhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: SpringBootHello
 * @description:
 * @author: 兔子
 * @create: 2021-12-10 20:55
 **/

@Controller
public class TestController {

    @RequestMapping("test")
    public String test(Model model) {
        model.addAttribute("msg", "正在使用thymeleaf");
        return "test";
    }

}
