package com.geekaca.ssm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//设置它是一个配置类
@Configuration
//扫描的路径
@ComponentScan("com.geekaca.ssm.controller")
@EnableWebMvc
public class SpringMvcConfig {

}
