package com.geekaca.web.forward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/second")
public class SecondServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("这是secondServlet service()");
        String myname = (String)req.getAttribute("myname");
        System.out.println("second 收到 值：" + myname);

        System.out.println("second age：" + req.getParameter("age"));
    }
}
