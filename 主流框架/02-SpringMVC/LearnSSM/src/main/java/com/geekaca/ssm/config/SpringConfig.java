package com.geekaca.ssm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//只负责 Spring 核心bean扫描
//设置它是一个配置类
@Configuration
//扫描的路径 还扫别的路径加逗号
@ComponentScan({"com.geekaca.ssm.service"})
//加载配置文件
@PropertySource("classpath:jdbc.properties")
//加载配置类
@Import({JdbcConfig.class, MyBatisConfig.class})
//事务驱动
@EnableTransactionManagement
public class SpringConfig {
}
