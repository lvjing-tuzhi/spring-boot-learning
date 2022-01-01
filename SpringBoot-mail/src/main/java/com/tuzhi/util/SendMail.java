package com.tuzhi.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: SpringBoot-mail
 * @description:
 * @author: 兔子
 * @create: 2022-01-01 17:14
 **/

@Service
public class SendMail {


    @Autowired
    JavaMailSenderImpl mailSender;

    /**
     *
     * @param suject 发送的主题
     * @param text 发送的内容
     * @param from 发送人的邮箱
     * @param to 发送到谁的邮箱
     * @param map 发送的附件
     * @return
     */

    public Boolean sendMail(String suject, String text, String from, String[] to, HashMap<String, File> map) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        try {
            helper.setSubject(suject);
            helper.setText(text,true);
            helper.setFrom(from);
            helper.setTo(to);
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                String  key = (String) entry.getKey();
                File value = (File) entry.getValue();
                helper.addAttachment(key,value);
            }
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
