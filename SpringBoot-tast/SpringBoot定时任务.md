# SpringBoot定时任务

# 1、开启定时支持

> xxxApplication.java 启动类中添加注解
>
> ```java
> //开启异步功能
> @EnableAsync
> //开启定时功能
> @EnableScheduling
> ```

```java
//开启异步功能
@EnableAsync
//开启定时功能
@EnableScheduling
@SpringBootApplication
public class SpringBootTastApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTastApplication.class, args);
    }

}
```

## 2、使用

> 在需要定时执行的方法上加注解
>
> cron:秒 分 时 日 月 周
>
> @Scheduled(cron = "0 * * * * *")

```java
@Service
public class TaskService {
    int i = 0;
//    cron:秒 分 时 日 月 周
    @Scheduled(cron = "0 * * * * *")
    public void hello() {

        System.out.println("hello"+i++);
    }
}
```