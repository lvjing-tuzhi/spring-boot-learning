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
