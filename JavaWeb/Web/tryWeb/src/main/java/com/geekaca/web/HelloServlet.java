package com.geekaca.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/hello","/demo1"},loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
    //接收GET请求 GET是HTTP默认提交方式
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        String str = req.getParameter("s");
////        System.out.println("收到了：" + str);
//        doPost(req,resp);
//    }

    //接收POST请求 参数不会直接显示在浏览器的地址栏 相对安全一点 post数据是放在http body中提交的
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("uname");
//        System.out.println("username：" + username);
//    }

    public HelloServlet() {
        System.out.println("构造器=========");
    }

    @Override
    public void destroy() {
        //做清理 比如关闭连接池
        System.out.println("destroy被调用");
    }

    @Override
    public void init() throws ServletException {
        //用于初始化 比如创建数据库连接池
        System.out.println("init被调用");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //既可以接收GET，又可以接收POST请求
        System.out.println("service---------");
        System.out.println(req.getParameter("s"));
    }
}
