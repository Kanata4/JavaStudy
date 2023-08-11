package com.geekaca.web.servlet;

import com.geekaca.web.mapper.UserMapper;
import com.geekaca.web.pojo.User;
import com.geekaca.web.utils.SqlUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/searchByUsername")
public class SearchServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type","text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String uname = req.getParameter("username");
        //trim删除了头部和尾部的空格
        if (uname == null || "".equals(uname.trim())){
            writer.write("alert('输入不能为空')");
            resp.sendRedirect(req.getContextPath()+"/search.html");
            return;
        }
        SqlSession sqlSession = SqlUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectUserByName(uname);
        //如果把列表的结果 展示给用户？
        if(userList.size() == 0){
            writer.write("没有找到用户名中含有" + uname + "的用户");
            return;
        }
        writer.write("找到结果如下：<br/>");
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            writer.write("用户名：" + user.getUsername());
            writer.write("<br/>性别：" + (user.getGender() == 1?"男":"女"));
            writer.write("<br/>城市：" + user.getCity());
            writer.write("<br/>爱好：" + user.getHobby());
            writer.write("<br/>介绍：" + user.getDesc() + "<hr>");
        }

    }
}
