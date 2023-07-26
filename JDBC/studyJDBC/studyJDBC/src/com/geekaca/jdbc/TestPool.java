package com.geekaca.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class TestPool {
    public static void main(String[] args) throws Exception {
        /**
         * 学习 连接池
         */
        //1， 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("studyJDBC/druid.properties"));
        //2, 构造连接池对象
        /**
         * DataSource 是Java官方的规范，数据库连接池规范   类似于 USB 接口规范 由国际组织定义的
         * DruidDataSourceFactory 连接池 是阿里巴巴厂商实现  ，类似于 一个具体的USB 设备，比如 USB鼠标
         *
         */
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //3 从数据库连接池 获取连接      可重用的连接
        Connection conn = dataSource.getConnection();
        //常规操作  Statement，ResultSet

        //归还连接  到连接池
        conn.close();

    }
}
