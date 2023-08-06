package com.geekaca.mybatis;

import com.geekaca.mybatis.mapper.QuestionMapper;
import com.geekaca.mybatis.pojo.Question;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    @org.junit.Test
    public void testSelectAll() throws IOException {
        SqlSession sqlSession = openSession();
        QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);

        //4.执行方法
        List<Question> brands = questionMapper.selectAll();
        brands.forEach(brand -> {
            System.out.println(brand);
        });

        //5.释放资源
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
