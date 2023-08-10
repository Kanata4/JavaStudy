package com.geekaca.web.forward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户访问/first ，转发请求 跳转到/second
 */
@WebServlet(urlPatterns = "/first")
public class FirstServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        //想把收到的参数传递过去
        req.setAttribute("myname",name);
        System.out.println("收到了：" + name);
        //1.作用：请求转发 2.哪些部分是可以自己修改的：/second
        req.getRequestDispatcher("/second").forward(req,resp);
    }
}
