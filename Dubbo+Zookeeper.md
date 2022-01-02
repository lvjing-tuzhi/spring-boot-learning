# Dubbo+Zookeeper

## 1、创建服务提供者

> 创建一个服务提供者模块

1. 导入maven依赖

   ~~~xml
   <dependency>
       <groupId>org.apache.curator</groupId>
       <artifactId>curator-framework</artifactId>
       <version>2.12.0</version>
   </dependency>
   <dependency>
       <groupId>org.apache.curator</groupId>
       <artifactId>curator-recipes</artifactId>
       <version>2.12.0</version>
   </dependency>
   <dependency>
       <groupId>org.apache.zookeeper</groupId>
       <artifactId>zookeeper</artifactId>
       <version>3.4.14</version>
       <!--排除这个slf4j-log4j12-->
       <exclusions>
           <exclusion>
               <groupId>org.slf4j</groupId>
               <artifactId>slf4j-log4j12</artifactId>
           </exclusion>
       </exclusions>
   </dependency>
   <dependency>
       <groupId>com.github.sgroschupf</groupId>
       <artifactId>zkclient</artifactId>
       <version>0.1</version>
   </dependency>
   <dependency>
       <groupId>org.apache.dubbo</groupId>
       <artifactId>dubbo-spring-boot-starter</artifactId>
       <version>2.7.3</version>
   </dependency>
   ~~~

2. 编写接口

   > TicketService.java

~~~java
public interface TicketService {
    String getTicket();
}
~~~

3. 编写实现类

   > TicketServiceImpl

```java
package com.tuzhi.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @program: Dubbo-Zookpeer
 * @description:
 * @author: 兔子
 * @create: 2022-01-02 16:31
 **/
@Service
@Component
public class TicketServiceImpl implements TicketService{
    @Override
    public String getTicket() {
        return "<兔子>";
    }
}

```

4. 配置application.properties文件

   ```properties
   #当前应用名字
   dubbo.application.name=provider-server
   #注册中心地址
   dubbo.registry.address=zookeeper://127.0.0.1:2181
   #扫描指定包下服务
   dubbo.scan.base-packages=com.tuzhi.service
   server.port=8081
   ```

## 2、创建服务消费者

> 创建一个服务消费者模块

1. 导入maven依赖

   ```xml
   <dependency>
      <groupId>org.apache.dubbo</groupId>
      <artifactId>dubbo-spring-boot-starter</artifactId>
      <version>2.7.3</version>
   </dependency>
   <!--zookeeper-->
   <!-- https://mvnrepository.com/artifact/com.github.sgroschupf/zkclient -->
   <dependency>
      <groupId>com.github.sgroschupf</groupId>
      <artifactId>zkclient</artifactId>
      <version>0.1</version>
   </dependency>
   <!-- 引入zookeeper -->
   <dependency>
      <groupId>org.apache.curator</groupId>
      <artifactId>curator-framework</artifactId>
      <version>2.12.0</version>
   </dependency>
   <dependency>
      <groupId>org.apache.curator</groupId>
      <artifactId>curator-recipes</artifactId>
      <version>2.12.0</version>
   </dependency>
   <dependency>
      <groupId>org.apache.zookeeper</groupId>
      <artifactId>zookeeper</artifactId>
      <version>3.4.14</version>
      <!--排除这个slf4j-log4j12-->
      <exclusions>
          <exclusion>
              <groupId>org.slf4j</groupId>
              <artifactId>slf4j-log4j12</artifactId>
          </exclusion>
      </exclusions>
   </dependency>
   ```

2. 编写方法

   > UserService.java

```java
package com.tuzhi.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @program: Dubbo-Zookpeer
 * @description:
 * @author: 兔子
 * @create: 2022-01-02 16:36
 **/
@Service
public class UserService {

    @Reference
    TicketService service;

    public void buyTicket() {
        String ticket = service.getTicket();
        System.out.println("从注册中心拿了一张" + ticket);
    }

}
```

3. 配置application.properties文件

   ```properties
   #当前应用名字
   dubbo.application.name=consumer-server
   #注册中心地址
   dubbo.registry.address=zookeeper://127.0.0.1:2181
   server.port=8082
   ```

4. 使用

   ```java
   @Autowired
   UserService userService;
   
   @Test
   void contextLoads() {
       userService.buyTicket();
   }
   ```

## 3、使用

1. 运行Zookeeper的zKServer.cmd

   > xxx>bin>zKServer

2. 运行dubbo-admin打包出来的jar包

   > dubbo-admin-0.0.1-SNAPSHOT.jar

3. 运行服务提供者
4. 运行服务消费者