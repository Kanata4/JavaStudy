package com.geekaca.web;

import com.geekaca.web.mapper.UserMapper;
import com.geekaca.web.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@WebServlet(urlPatterns = "/testRegister")
public class RegisterServlet extends HelloServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //设置网页显示中文
        resp.setHeader("Content-type","text/html;charset=UTF-8");

        String uname = req.getParameter("username");
        String pwd = req.getParameter("password");
        String confirm = req.getParameter("confirm");
        if (pwd.equals(confirm)){
            System.out.println("username:" + uname + " password:" + pwd +  " confirm:" + confirm);
        } else {
            System.out.println("两次密码不一致！");
        }
        String[] genders = req.getParameterValues("gender");
        System.out.println("选中的性别：");
        for (int i = 0; i < genders.length; i++) {
            System.out.println(genders[i]);
        }
        String[] hobbies = req.getParameterValues("hobby");
        if (hobbies != null){
            System.out.println("选中的爱好：");
            for (int i = 0; i < hobbies.length; i++) {
                System.out.println(hobbies[i]);
            }
        }
        String[] cities = req.getParameterValues("city");
        for (int i = 0; i < cities.length; i++) {
            System.out.println(cities[i]);
        }
        String desc = req.getParameter("desc");
        if (hobbies != null){
            System.out.println("个人描述：" + desc);
        }

        User user1 = new User();
        user1.setUsername(uname);
        user1.setPassword(pwd);

        SqlSession sqlSession = openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.add(user1);
        sqlSession.commit();
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
