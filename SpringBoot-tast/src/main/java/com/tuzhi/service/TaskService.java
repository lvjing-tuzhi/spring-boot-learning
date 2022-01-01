package com.tuzhi.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @program: SpringBoot-tast
 * @description:
 * @author: 兔子
 * @create: 2022-01-01 20:24
 **/

@Service
public class TaskService {
    int i = 0;
//    cron:秒 分 时 日 月 周
    @Scheduled(cron = "0 * * * * *")
    public void hello() {

        System.out.println("hello"+i++);
    }
}
