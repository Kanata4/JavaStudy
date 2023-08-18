package com.geekaca.web.controller;

import com.geekaca.web.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/user")
public class ObjectServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 从数据库查询一个User信息
         * 返回给JSP展示
         */

//        User user = new User();
//        user.setId(12);
//        user.setUname("张三");
//        user.setAddr("广东深圳蛇口");
        /**
         * 从DB中查询所有用户的信息
         */
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(12+i);
            user.setUname("张三"+i);
            user.setAddr("广东深圳蛇口");
            list.add(user);
        }
//        req.setAttribute("u",user);
        req.setAttribute("list", list);
        req.getRequestDispatcher("/userInfo.jsp").forward(req,resp);

    }
}
