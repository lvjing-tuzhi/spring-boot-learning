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
```

## 3、使用

> 在控制层中使用

```java
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

//    授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("======执行了授权doGetAuthorizationInfo======:"+principalCollection);
//        添加权限方法
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        获取Subject对象，这样就可以得到认证方法传过来的数据
        Subject subject = SecurityUtils.getSubject();
//        获得User数据
        User user = (User) subject.getPrincipal();
//        根据数据库查出来的权限进行授权
        info.addStringPermission(user.getPerm());
        return info;
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
//        密码交给Shiro验证,并且可以把user传值给Subjetc，这样其他地方可以通过Subject得到user数据
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
```

## 4、Shiro整合Thymeleaf

1. 导入maven依赖

   ```xml
   <dependency>
       <groupId>com.github.theborakompanioni</groupId>
       <artifactId>thymeleaf-extras-shiro</artifactId>
       <version>2.0.0</version>
   </dependency>
   ```

2. 添加配置

   > 在ShiroConfig.java中

```java
//    Shiro整合Thymeleaf：ShiroDialect
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
```

3. 使用

   ```html
   <html lang="en" xmlns:shiro="http://www.pollix.at/thymeleaf/shiro">
   ```

   ```html
   <div shiro:hasPermission="user:add">
       <a href="/user/add">添加</a>
   </div>
   <br>
   <div shiro:hasPermission="user:update">
       <a th:href="@{/user/update}">更新</a>
   </div>
   ```