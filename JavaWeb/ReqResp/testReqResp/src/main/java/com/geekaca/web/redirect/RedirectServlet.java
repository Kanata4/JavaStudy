package com.geekaca.web.redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/go")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RedirectServlet service()");
//        resp.sendRedirect("http://www.bing.com");
//        req.setAttribute("myname","haha");//重定向不能传递request中的值
        String contextPath = req.getContextPath();//动态获取当前web应用的访问路径
        resp.sendRedirect(contextPath + "/second?age=19");//URL传值
    }
}
