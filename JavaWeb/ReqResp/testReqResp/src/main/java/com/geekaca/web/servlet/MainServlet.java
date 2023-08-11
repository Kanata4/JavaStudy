package com.geekaca.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type","text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        String myname = (String)req.getAttribute("username");
        writer.write("欢迎来到首页！" + myname);

    }
}
