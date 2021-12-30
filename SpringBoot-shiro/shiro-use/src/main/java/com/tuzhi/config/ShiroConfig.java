package com.tuzhi.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: SpringBoot-shiro
 * @description:
 * @author: 兔子
 * @create: 2021-12-28 20:38
 **/

@Configuration
public class ShiroConfig {

    //    ShiroFilterFactoryBean:3
//    业务代码区
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultWebSecurityManager);

        /*
            anon:无需认证就可以访问
            authc:必须认证了才能访问
            user:必须拥有记住我功能才可以用
            perms：拥有对某个资源都权限才能访问
            role:拥有某个角色权限才能反问
         */
        Map<String, String> map = new LinkedHashMap<>();

//        设置具有哪些权限才可以访问
        map.put("/user/add","perms[user:add]");
        map.put("/user/update","perms[user:update]");

//        需要认证的路径
        map.put("/user/*","authc");

        bean.setFilterChainDefinitionMap(map);

//        没有认证就跳转
        bean.setLoginUrl("/login");

//        没有授权就跳转
        bean.setUnauthorizedUrl("/unauthorized");

        return bean;
    }

    //    DefaulWebSecurityManager:2
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

//    创建realm对象，需要自定义：1
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }



}
