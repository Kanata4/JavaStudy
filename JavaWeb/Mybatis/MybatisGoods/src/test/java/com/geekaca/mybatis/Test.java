package com.geekaca.mybatis;

import com.geekaca.mybatis.mapper.GoodsMapper;
import com.geekaca.mybatis.pojo.Goods;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    @org.junit.Test
    public void testSelectByCondition(){
        SqlSession sqlSession = openSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        Goods goods = new Goods();
        goods.setPrice(200.00);
        //再加条件
        goods.setTitle("华");
        List<Goods> goodsList = goodsMapper.selectByCondition(goods);
        goodsList.forEach(goods1 -> {
            System.out.println(goods1);
        });
    }

    @org.junit.Test
    public void testSelectByTitle(){
        SqlSession sqlSession = openSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);

        String title = "果";
        title = "%" + title + "%";
        List<Goods> goodsList = goodsMapper.selectByTitle(title);
        goodsList.forEach(goods -> {
            System.out.println(goods);
        });

        sqlSession.close();
    }

    @org.junit.Test
    public void testInsert(){
        SqlSession sqlSession = openSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        Goods goods = new Goods();
        goods.setTitle("OPPO耳机");
        goods.setPrice(600.00);
        int inserted = goodsMapper.insertGoods(goods);
        System.out.println("执行insert后，受到影响的记录条数：" + inserted);
        sqlSession.close();
    }

    private static SqlSession openSession() {
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //会话
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }
}
