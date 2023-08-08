package com.geekaca.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Thread
 * 遵循java的web 规则
 * 1.继承
 * 2.重写方法 CTRL+O
 * 3.增加注解
 * 定义如何访问servlet
 */
@WebServlet(urlPatterns = "/hello")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello java web servlet!");
        String name = req.getParameter("name");
        System.out.println("doGet:");
        System.out.println("name:" + name);
        PrintWriter writer = resp.getWriter();
        writer.write("hello web");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受单一的值
        String username = req.getParameter("username");
        System.out.println("doPost:");
        System.out.println("username :" + username);
        //接收多个值 爱好
        String[] hobby = req.getParameterValues("hobby");
    }
}


