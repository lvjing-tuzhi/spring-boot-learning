package com.tuzhi.config;

import com.tuzhi.pojo.User;
import com.tuzhi.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @program: SpringBoot-shiro
 * @description:
 * @author: 兔子
 * @create: 2021-12-28 20:40
 **/


public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

//    授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("======执行了授权doGetAuthorizationInfo======");
        return null;
    }

//    认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("======执行了认证doGetAuthenticationInfo======");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.queryUserByName(token.getUsername());
        if (user == null) {//判断用户存不存在
            return null;
        }
//        密码交给Shiro验证
        return new SimpleAuthenticationInfo("",user.getPassword(),"");
    }
}
