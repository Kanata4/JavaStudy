package com.geekaca.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
//针对mybatis配置
public class MybatisConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFatoryBean(DataSource ds){
        //Mybatis session的工厂bean ，用来创建SqlSession的
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setTypeAliasesPackage("com.geekaca.domain");
        ssfb.setDataSource(ds);
        return ssfb;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        //设置Mapper 扫描路径

        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        //默认约定 mapper类何mapper XML文件文字要一样
        msc.setBasePackage("com.geekaca.dao");
        return msc;
    }
}
