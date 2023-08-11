package com.geekaca.web.servlet;

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

//@WebServlet(urlPatterns = "/login")
@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    /**
     *
     * @param req 请求
     * @param resp 响应
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //因为返回客户端（浏览）展示 ， 需要设置内容类型和编码（默认是ISO-8859-1编码），英文编码，中文在这个编码下乱码
        resp.setHeader("Content-Type","text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        //接收参数
        String uname = req.getParameter("username");
        String pwd = req.getParameter("password");
        System.out.println("收到参数值：" + uname);
        //显示在网页上
        PrintWriter writer = resp.getWriter();
//        writer.write("你输入了用户名：" + uname);
        //做判断
//        if ("admin".equals(uname) && "123456".equals(pwd)){
//            //
//            writer.write("登陆成功,欢迎您：" + uname);
//        } else {
//            writer.write("<font color='red'>登陆失败！</font>");
//        }

        //调用mybatis
        SqlSession sqlSession = openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername(uname);
        user.setPassword(pwd);
        int cnt = userMapper.selectByUnamePass(user);
        if (cnt > 0){
//            writer.write("登陆成功！欢迎您：" + uname);
            //页面跳转
            //想把收到的参数传递过去
            req.setAttribute("username",uname);
            req.getRequestDispatcher("/main").forward(req,resp);
            return;

        }else {
            writer.write("登陆失败！");
        }

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
