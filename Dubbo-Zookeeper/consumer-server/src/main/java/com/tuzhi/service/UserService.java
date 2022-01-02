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
