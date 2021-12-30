# yaml文件的使用

## 1、用法

1. 配置端口号

   ~~~yaml
   server：
     prot: 8080
     servlet:
   ~~~

2. 基本类型包括String，都不用加“”

3. 数组1

   ~~~yaml
   Countries: 
       - Chine
       - USA
   ~~~

4. 数组2

   ~~~yaml
   Countries: [chine,usa]
   ~~~

## 2、注入值

1. 导入maven依赖

   ~~~xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-configuration-processor</artifactId>
       <optional>true</optional>
   </dependency>
   ~~~

2. 创建实体类

   ~~~java
   @Component
   @Data
   @AllArgsConstructor
   @NoArgsConstructor
   //通过这个注解判定yaml中的值
   @ConfigurationProperties(prefix = "user")
   public class User {
       private String userName;
       private int age;
   
   }
   ~~~

3. yaml使用

   ~~~
   user:
     userName: "吕竟"
     age: 18