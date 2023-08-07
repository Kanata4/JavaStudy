package com.geekaca.mybatis;

import com.geekaca.mybatis.mapper.QuestionnaireMapper;
import com.geekaca.mybatis.pojo.Option;
import com.geekaca.mybatis.pojo.Questionnaire;
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
    public void testSelectQuestionnaireContentById(){
        SqlSession sqlSession = openSession();
        QuestionnaireMapper questionnaireMapper = sqlSession.getMapper(QuestionnaireMapper.class);

        int id = 1;
        Map map = new HashMap();
        map.put("id",id);
        List<Option> question1 = questionnaireMapper.selectQuestionnaireContentById(map);
        question1.forEach(question -> {
            System.out.println(question);
        });

        sqlSession.close();
    }

    @org.junit.Test
    public void testSelectAll() throws IOException {
        SqlSession sqlSession = openSession();
        QuestionnaireMapper questionnaireMapper = sqlSession.getMapper(QuestionnaireMapper.class);

        //4.执行方法
        List<Questionnaire> brands = questionnaireMapper.selectAll();
        brands.forEach(questionnaire -> {
            System.out.println(questionnaire);
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
