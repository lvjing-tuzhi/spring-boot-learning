package com.tuzhi.springbootdatajdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @program: SpringBoot-data-JDBC
 * @description:
 * @author: 兔子
 * @create: 2021-12-23 10:49
 **/

@RestController
public class JdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("list")
    public List<Map<String, Object>> list() {
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @GetMapping("add")
    public String add() {
        String sql = "insert into mybatis.user (id, name, password)\n" +
                "values (6,'springboot','123456aaa');";
        jdbcTemplate.update(sql);
        return "add";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable("id") int id) {
        String sql ="update mybatis.user set name = ?, password = ? where id="+id;
        Object[] objects = new Object[2];
        objects[0] = "ts";
        objects[1] = "aaaaa";
        jdbcTemplate.update(sql,objects);
        return "update";
    }

    @GetMapping("delete")
    public String delete() {
        String sql = "delete from mybatis.user where id = 6";
        jdbcTemplate.update(sql);
        return "delete";
    }
}
