package com.tuzhi;

import com.tuzhi.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootHelloApplicationTests {

    @Autowired
    User user;

    @Test
    void contextLoads() {
        System.out.println(user);
    }

}
