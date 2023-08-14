package com.geekaca.jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * todo:
         * 当你访问了这个servlet时候
         * 会向request作用域中存入变量 myName
         * 然后页面转发请求jsp
         *
         * jsp中取出myName变量值显示
         */
        System.out.println("TestServlet service----");
//        req.setAttribute("myName","Jack");
        HttpSession session = req.getSession();
        session.setAttribute("age",199);
        //页面的请求转发
        req.getRequestDispatcher("/EL.jsp").forward(req,resp);
        //重定向 无法把request作用域的值传递过去
//        resp.sendRedirect("/JSP814/EL.jsp");

    }
}
