package com.tuzhi;

import com.tuzhi.util.SendMail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;

@SpringBootTest
class SpringBootMailApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;
    @Autowired
    SendMail sendMail;

    @Test
    void contextLoads() {
//        发送一个简单的邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("这是一个SpringBoot邮箱测试");
        message.setText("这是简单邮件的内容");
        message.setFrom("542918096@qq.com");
        message.setTo("1970593115@qq.com");
        mailSender.send(message);
    }
    @Test
    void contextLoads2() throws MessagingException {
//        发送一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true);
        message.setSubject("这是一个SpringBoot邮箱测试");
        message.setText("<p style='color:red'>这是简单邮件的内容</p>",true);
        message.addAttachment("1.png",new File("C:\\Users\\Lenovo\\Desktop\\1.png"));
//        message.addAttachment("2.png",new File("C:\\Users\\Lenovo\\Desktop\\1.png"));
        message.setFrom("542918096@qq.com");
        message.setTo("1970593115@qq.com");
        mailSender.send(mimeMessage);
    }

    @Test
    void testUtil() throws MessagingException {
        String suject = "发送邮箱工具类";
        String text = "邮箱工具类测试";
        String from = "542918096@qq.com";
        String[] to = {"1970593115@qq.com"};
        HashMap<String, File> map = new HashMap<>();
        map.put("ce.png",new File("C:\\Users\\Lenovo\\Desktop\\1.png"));
        Boolean flag = sendMail.sendMail(suject, text, from, to, map);
        if (flag) {
            System.out.println("======发送成功======");
        }else {
            System.out.println("======发送失败======");
        }
    }

}
