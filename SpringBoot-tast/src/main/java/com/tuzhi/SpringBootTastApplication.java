package com.tuzhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

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
