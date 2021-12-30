# SpringBoot使用Shiro

## 1、导入maven依赖

```xml
<dependency>
    <groupId>org.apache.shiro</groupId>
    <artifactId>shiro-spring</artifactId>
    <version>1.8.0</version>
</dependency>
```

## 2、创建配置类

> config>ShiroConfig.java

```java
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

//        需要验证的路径
        map.put("/user/*","authc");

        bean.setFilterChainDefinitionMap(map);

//        没有权限就跳转
        bean.setLoginUrl("/login");

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
```

## 3、创建业务类

> config>UserRealm

```java
public class UserRealm extends AuthorizingRealm {
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
        String username = "admin";
        String password = "admin";
        if (!token.getUsername().equals(username)) {//判断用户存不存在
            return null;
        }
//        密码交给Shiro验证
        return new SimpleAuthenticationInfo("",password,"");
    }
}
```

## 3、使用

> 在控制层中使用

```java
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
            model.addAttribute("msg","用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e) {
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }
}
```