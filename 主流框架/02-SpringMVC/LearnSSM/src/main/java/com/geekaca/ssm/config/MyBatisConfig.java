package com.geekaca.ssm.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MyBatisConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        //类型别名的扫描包
        factoryBean.setTypeAliasesPackage("com.geekaca.ssm.domain");
        return factoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        //扫描映射
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.geekaca.ssm.dao");
        return msc;
    }

}
