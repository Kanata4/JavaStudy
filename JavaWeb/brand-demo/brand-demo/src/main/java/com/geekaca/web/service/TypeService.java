package com.geekaca.web.service;

import com.geekaca.web.mapper.BrandMapper;
import com.geekaca.web.mapper.TypeMapper;
import com.geekaca.web.pojo.Brand;
import com.geekaca.web.pojo.Type;
import com.geekaca.web.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TypeService {
    public int addType(Type type){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
        int i = typeMapper.addType(type);
        sqlSession.close();
        return i;
    }

    public List<Type> selectAllType(){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
        List<Type> type = typeMapper.selectAllType();
        sqlSession.close();
        return type;
    }

    public int deleteType(int id){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
        int i = typeMapper.deleteType(id);
        sqlSession.close();
        return i;
    }
}
