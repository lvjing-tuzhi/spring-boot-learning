package com.tuzhi.springbootdatajdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @program: SpringBoot-data-JDBC
 * @description: Druid配置
 * @author: 兔子
 * @create: 2021-12-24 18:38
 **/

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Bean
//    后台监控
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");

        HashMap<String, String> initParameters = new HashMap<>();
//        账号密码配置，后台监控通过这个账号密码进行登入
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","admin");

//        允许谁可以访问
        initParameters.put("allow","");

        bean.setInitParameters(initParameters);
        return bean;
    }

//    过滤
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        HashMap<String, String> initParameters = new HashMap<>();
//        过滤这些请求，并且不进行统计
        initParameters.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParameters);
        return bean;
    }

}
