# 使用thymeleaf来使用模板引擎

## 1、导入依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

## 2、直接在html中使用

* 在html中引入标签资源 xmlns:th="http://www.thymeleaf.org"

  ~~~html
  <html lang="en" xmlns:th="http://www.thymeleaf.org">
  </html>
  ~~~


* 文档地址：https://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html

# 注：

1. 所有静态资源 都用thymeleaf来引用
2. th:@{/css/**}
2. 引用资源使用@