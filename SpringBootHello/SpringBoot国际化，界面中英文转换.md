# SpringBoot国际化，界面中英文转换

## 1、创建properties

1. login.properties

   ~~~properties
   forgetPassword=忘记密码
   logIn=登录  
   password=密码
   userName=用户名
   ~~~

2. login_en_US.properties

   ~~~properties
   forgetPassword=forgetPassword
   logIn=LogIn
   password=password
   userName=username
   ~~~

1. login_zh_CN.properties

   ~~~properties
   forgetPassword=忘记密码
   logIn=登录  
   password=密码
   userName=用户名
   ~~~

## 2、html中使用

1. 使用

   ~~~html
   <input type="text" th:placeholder="#{userName}"/>
   
   <input type="password" th:placeholder="#{password}" />
   
   <a href="#" class="flip-link btn btn-info" id="to-recover">[[#{forgetPassword}]]</a>
   
   <a type="submit" href="index.html" class="btn btn-success"/>[[#{logIn}]]</a></span>
   ~~~

2. 跳转按钮

   ~~~html
   <a th:href="@{login.html(l='zn_CN')}" class="flip-link btn btn-info">中文</a>
   
   <a type="submit" th:href="@{login.html(l='en_US')}" class="btn btn-success"/>English</a>
   ~~~

## 3、自定义LocaleResolver进行处理

1. 创建MyLocaleResolver

   ```java
   public class MyLocaleResolver implements LocaleResolver {
       @Override
       public Locale resolveLocale(HttpServletRequest request) {
           String l = request.getParameter("l");
           System.out.println(l);
           Locale aDefault = Locale.getDefault();
           if (l != null) {
               String[] s = l.split("_");
               aDefault = new Locale(s[0],s[1]);
           }
           return aDefault;
       }
   
       @Override
       public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
   
       }
   }
   ```

2. 在自定义的MyMvcConfig中进行绑定

   ```java
   @Configuration
   public class MyMvcConfig implements WebMvcConfigurer {
       @Override
       public void addViewControllers(ViewControllerRegistry registry) {
           registry.addViewController("/").setViewName("login");
           registry.addViewController("/login.html").setViewName("login");
       }
   
       //注册自定义国际化
       @Bean
       public LocaleResolver localeResolver() {
           return new MyLocaleResolver();
       }
   }
   ```