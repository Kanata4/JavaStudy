package com.geekaca.web;

import com.geekaca.web.mapper.UserMapper;
import com.geekaca.web.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/register")
public class RegServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type","text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirm = req.getParameter("confirm");
        String gender = req.getParameter("gender");

        String[] hobbies = req.getParameterValues("hobby");
        String city = req.getParameter("city");
        String desc = req.getParameter("desc");

        if(password == null || confirm == null){
            //不允许为空
            writer.write("密码不允许为空！");
            return;
        }
        if (!password.equals(confirm)){
            writer.write("两次密码不一致！");
            return;
        }
        //调用mybatis
        SqlSession sqlSession = openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userMapper.add(user);

        writer.write("你的注册信息如下：");
        writer.write("<br/>");
        writer.write("用户名：" + username);
        writer.write("<br/>");
        writer.write("性别：" + (gender.equals("1")?"男":"女"));
        writer.write("<br/>");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < hobbies.length; i++) {
            switch (hobbies[i]){
                case "1":
                    stringBuilder.append("旅游");
                    break;
                case "2":
                    stringBuilder.append("电影");
                    break;
                case "3":
                    stringBuilder.append("游戏");
                    break;
            }
        }
        writer.write("爱好：" + stringBuilder.toString());
        writer.write("<br/>");
        writer.write("城市：" + city);
        writer.write("<br/>");
        writer.write("描述：" + desc);
        writer.write("<br/>");
        writer.write("<a href=\"login.html\">前往登录</a>");

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
