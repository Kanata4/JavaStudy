package com.geekaca.web.service;

import com.geekaca.web.mapper.BrandMapper;
import com.geekaca.web.pojo.Brand;
import com.geekaca.web.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BrandService {
    public List<Brand> selectAll(){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();
        sqlSession.close();
        return brands;
    }
}
