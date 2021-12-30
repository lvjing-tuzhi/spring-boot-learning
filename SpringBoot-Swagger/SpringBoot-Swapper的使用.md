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
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
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