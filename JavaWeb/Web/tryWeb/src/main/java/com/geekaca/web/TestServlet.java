package com.geekaca.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HelloServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TestServlet service.....");

        String method = req.getMethod();
        System.out.println(method);//GET

        //String getContextPath(): 获取虚拟目录(项目访问路径) : /request-demo
        String contextPath = req.getContextPath();
        System.out.println("contextPath:" + contextPath);

        //String getQueryString():获取请求参数（GET方式）:
        String queryString = req.getQueryString();
        System.out.println("queryString:" + queryString);

        //获取请求头 user-agent：浏览器的版本信息
        /**
         * 告诉服务器 我是什么浏览器
         * 手机浏览器和电脑浏览器不同
         * 适配
         */
    }
}
