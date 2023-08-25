package com.geekaca.service;

import com.geekaca.mapper.TypeMapper;
import com.geekaca.pojo.BrandType;
import com.geekaca.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

//service  业务逻辑层
public class TypeService {

    //有利于单独进行测试
    public List<BrandType> getAll(){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
        List<BrandType> brandTypes = typeMapper.selectAll();
        sqlSession.close();
        return brandTypes;
    }

}
