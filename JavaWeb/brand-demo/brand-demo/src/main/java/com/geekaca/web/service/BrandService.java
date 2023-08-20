package com.geekaca.web.service;

import com.geekaca.web.mapper.BrandMapper;
import com.geekaca.web.pojo.Brand;
import com.geekaca.web.utils.SqlSessionFactoryUtils;
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

    public int addBrand(Brand brand){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int i = brandMapper.addBrand(brand);
        sqlSession.close();
        return i;
    }

    public Brand selectById(int id){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = brandMapper.selectById(id);
        sqlSession.close();
        return brand;
    }

    public int updateBrand(Brand brand){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int i = brandMapper.updateBrand(brand);
        sqlSession.close();
        return i;
    }

    public int deleteBrand(int id){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int i = brandMapper.deleteBrand(id);
        sqlSession.close();
        return i;
    }

    public List<Brand> selectByBrandName(String brandName){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectByCompanyName(brandName);
        sqlSession.close();
        return brands;
    }
}
