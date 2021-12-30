package com.tuzhi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @program: SpringBoot-Spring-Security
 * @description: 安全权限配置
 * @author: 兔子
 * @create: 2021-12-27 17:02
 **/

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        添加用户认证权限
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
//        没有访问权限的话，跳转到登录页面
        http.formLogin().loginPage("/login").loginProcessingUrl("/login").usernameParameter("username").passwordParameter("username");
//        开启注册
//        解决跨域问题
        http.csrf().disable();
        http.logout().logoutSuccessUrl("/");
        http.rememberMe().rememberMeParameter("remember");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        在内存中进行帐户密码判断，并且给予相对于的权限
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles("vip1","vip2","vip3")
                .and().withUser("user").password(new BCryptPasswordEncoder().encode("user")).roles("vip1");
    }
}
