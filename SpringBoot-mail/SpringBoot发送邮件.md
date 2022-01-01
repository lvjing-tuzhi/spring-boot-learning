## SpringBoot发送邮件

## 1、导入依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```

## 2、配置参数

> application.properties

```properties
spring.mail.host=smtp.qq.com
spring.mail.username=邮箱账号
#发送方的pop3的授权码
spring.mail.password=mwwyaodxsqnubebb
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
```

## 3、实现

1. 发送一个简单邮件

   ```java
    @Autowired
       JavaMailSenderImpl mailSender;
   
       @Test
       void contextLoads() {
   //        发送一个简单的邮件
           SimpleMailMessage message = new SimpleMailMessage();
           message.setSubject("这是一个SpringBoot邮箱测试");
           message.setText("这是简单邮件的内容");
           message.setFrom("xxx@qq.com");
           message.setTo("xxx@qq.com");
           mailSender.send(message);
   //        发送一个复杂的邮件
           MimeMessage mimeMessage = mailSender.createMimeMessage();
           MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true);
           message.setSubject("这是一个SpringBoot邮箱测试");
           message.setText("<p style='color:red'>这是简单邮件的内容</p>",true);
           message.addAttachment("1.png",new File("C:\\Users\\Lenovo\\Desktop\\1.png"));
           message.addAttachment("2.png",new File("C:\\Users\\Lenovo\\Desktop\\1.png"));
   
           message.setFrom("xxx@qq.com");
           message.setTo("xxx@qq.com");
           mailSender.send(mimeMessage);
       }
   ```