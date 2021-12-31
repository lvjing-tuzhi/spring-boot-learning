# SpringBoot-Swapper的使用

## 1、导入maven依赖

> 2.x版本导入两个依赖
>
> 访问路径为：http://127.0.0.1:8080/swagger-ui.html

```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>
```

> 3.x版本导入一个依赖
>
> 访问路径为：http://127.0.0.1:8080/swagger-ui/index.html

```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
```

## 2、创建配置类

> config>SwapperConfig.java

```java
@Configuration
@EnableSwagger2  //开启Swagger2
public class SwapperConfig {

    //配置Swapper的Docket的bean实例
    @Bean
    public Docket docket(Environment environment) {
//        获取到当前是生产环境还是发布环境，从而来进行自动的改变swapper配置
        Profiles dev = Profiles.of("dev");
        boolean flag = environment.acceptsProfiles(dev);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)
                .select()
//                RequestHandlerSelectors:
//                    basePackage 指定要扫描的包
//                    any() 扫描全部
//                    none() 不扫描
//                    withClassAnnotation 扫描类上的注解，参数是一个注解的放射对象，annocation.class
//                    withMethodAnnotation 扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.tuzhi.controller"))
                .paths(PathSelectors.any())//过滤路径
                .build();
    }

//    配置Swapper信息
    public ApiInfo apiInfo() {
        Contact contact = new Contact("吕竟", "127.0.0.1/hello", "542918096@qq.com");
        return new ApiInfo(
                "兔子的Api",
                "这是一个HelloSwapper",
                "2.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>()

        );
    }

}
```

## 3、注解

1. @ApiModel("xx实体类"):加在实体类上，给类注释

2. @ApiModelProperty("用户名xx"):加在属性上，给属性注释

3. @ApiOperation("xxx接口"):加在控制方法上，给方法注释

4. @Api(tag = {"xxx接口"}):加在控制类上，给控制类注释

5. ```java
   @ApiImplicitParams(value = {
           @ApiImplicitParam(name = "nameHello", value = "你要Hello的内容",dataType = "String")
   }) //加在控制类方法上，给方法都参数添加注释
   ```

6. 例

   ```java
   @ApiModel("用户")
   @Data
   public class User {
       @ApiModelProperty("用户名")
       private String username;
       @ApiModelProperty("密码")
       private String password;
   }
   ```

   ```java
   @RestController
   @Api(tags = {"用户接口"})
   public class HelloController {
   
       @GetMapping("/hello/{nameHello}/{author}")
       @ApiOperation("hello")
   
       @ApiImplicitParams(value = {
               @ApiImplicitParam(name = "nameHello", value = "你要Hello的内容",dataType = "String"),
               @ApiImplicitParam(name = "author", value = "作者名",dataType = "int")
       })
       public String hello(String nameHello,int author) {
           return "hello" + nameHello + author;
       }
   
       @PostMapping("/add")
       @ApiOperation("添加用户")
       public User add(User user) {
   
           return user;
       }
   
   }
   ```