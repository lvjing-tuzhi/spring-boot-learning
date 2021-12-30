package com.tuzhi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @program: SpringBoot-Swagger
 * @description:
 * @author: 兔子
 * @create: 2021-12-30 21:56
 **/

@Configuration
@EnableSwagger2  //开启Swagger2
public class SwapperConfig {

    //配置Swapper的Docket的bean实例
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

//    配置Swapper信息
    public ApiInfo apiInfo() {
        Contact contact = new Contact("吕竟", "127.0.0.1/hello", "542918096@qq.com");
        return new ApiInfo(
                "兔子的Api",
                "这是一个HelloSwapper",
                "2.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>()

        );
    }

}
