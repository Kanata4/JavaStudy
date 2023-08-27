package com.geekaca.service;

import com.geekaca.mapper.BrandMapper;
import com.geekaca.pojo.Brand;
import com.geekaca.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    //1. 创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

//    public List<Brand> selectAll() {
//        //2. 获取SqlSession对象
//        SqlSession sqlSession = factory.openSession();
//        //3. 获取BrandMapper
//        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
//
//        //4. 调用方法
//        List<Brand> brands = mapper.selectAll();
//
//        //5.释放资源
//        sqlSession.close();
//
//        return brands;
//    }

    //方法重载
    public List<Brand> selectAll(Integer pageNo, Integer pageSize) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int start = (pageNo - 1) * pageSize;

        //4. 调用方法
        List<Brand> brands = mapper.selectAll(start,pageSize);

        //5.释放资源
        sqlSession.close();

        return brands;
    }

    public int getAllBrandsCount(){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int count = mapper.selectAllCount();
        sqlSession.close();
        return count;
    }

    public int add(Brand brand) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        int i = mapper.add(brand);
        sqlSession.commit();//提交事务

        //5.释放资源
        sqlSession.close();

        return i;
    }

    public List<Brand> search(Integer pageNo, Integer pageSize,Brand brand) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int start = (pageNo - 1) * pageSize;

        //4. 调用方法
        List<Brand> brands = mapper.search(start,pageSize,brand);

        //5.释放资源
        sqlSession.close();

        return brands;
    }

    public int update(Brand brand) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        int i = mapper.update(brand);
        sqlSession.commit();//提交事务

        //5.释放资源
        sqlSession.close();

        return i;
    }

    public int delete(Integer id) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        int i = mapper.delete(id);
        sqlSession.commit();//提交事务

        //5.释放资源
        sqlSession.close();

        return i;
    }

    public int queryBrandsCount(Integer pageNo, Integer pageSize, Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int start = (pageNo - 1) * pageSize;
        int count = mapper.queryBrandCount(start,pageSize,brand);
        sqlSession.close();
        return count;
    }
}
