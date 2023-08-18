package com.geekaca.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/hello")
public class MyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //既能够接收get，又能够接收post
        String uname = req.getParameter("uname");
        String age = req.getParameter("age");
        System.out.println(uname + " age:" + age);
        if (age != null){
            //String -> int
            int ageI = Integer.parseInt(age);
        } else {
            //向JSP传值
             req.setAttribute("err","age 不能为空！");
             //页面转发 直接发生在服务端，用户无感知，地址栏url不变化
             //只能转发请求到当前web应用内部
//             req.getRequestDispatcher("/login.jsp").forward(req,resp);
            //页面重定向 告诉浏览器重新访问一个地址
            //可以跳出web应用，比如跳到baidu
            int height = 99;
//            resp.sendRedirect(req.getContextPath()+"/index.jsp?var=" + height);
        }
        //比如： 登陆成功后 就可以把用户信息存入session 方便随时取用
        HttpSession session = req.getSession();
        session.setAttribute("uname",uname);
        req.getRequestDispatcher("/user").forward(req,resp);
        /**
         * 值的传递
         * HTML(JSP) -> servlet
         *      GET/POST
         * Servlet -> JSP
         *      HTTPServletRequest serAttribute(key, value) 只能和请求转发组合传值
         *      不能和重定向组合传值
         * Servlet -> HTML 传值 没用
         */
    }
}
