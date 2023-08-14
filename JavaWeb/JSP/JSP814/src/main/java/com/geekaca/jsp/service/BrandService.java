package com.geekaca.jsp.service;

import com.geekaca.jsp.mapper.BrandMapper;
import com.geekaca.jsp.pojo.Brand;
import com.geekaca.jsp.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Brand> selectAll(){
        SqlSession sqlSession = factory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectAll();

        sqlSession.close();

        return brands;
    }
}
