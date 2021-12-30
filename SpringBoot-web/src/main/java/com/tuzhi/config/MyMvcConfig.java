package com.tuzhi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: SpringBoot-web
 * @description: 自定义视图解析器
 * @author: 兔子
 * @create: 2021-12-11 16:36
 **/

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("index");
    }

//    添加自定义拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns(
//                "/","/login.html","/css/**","/img/**","js/**","/user/login"
//        );
//    }

    //注册自定义国际化
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
