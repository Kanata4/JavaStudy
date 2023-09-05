package com.geekaca.boot.controller;

import com.geekaca.boot.domain.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
public class BrandController {
    //属性注入
    //使用@Value读取单一属性数据
    @Value("${lesson}")
    private String lesson;
    @Value("${server.port}")
    private Integer port;
    @Value("${enterprise.subject[0]}")
    private String subject_00;

    @Autowired
    private Environment environment;
    @Autowired
    private Enterprise enterprise;


    @RequestMapping("/{id}")
    private String getById(@PathVariable Integer id) {
        System.out.println(lesson);
        System.out.println(port);
        System.out.println(subject_00);
        System.out.println(environment.getProperty("lesson"));
        System.out.println(environment.getProperty("server.port"));
        System.out.println(environment.getProperty("subject[0]"));
        System.out.println(enterprise);
        return "hello, spring boot";
    }
}

