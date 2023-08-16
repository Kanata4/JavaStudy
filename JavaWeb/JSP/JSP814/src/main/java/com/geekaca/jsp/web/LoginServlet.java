package com.geekaca.jsp.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    /**
     *
     * @param req 请求
     * @param resp 响应
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //因为返回客户端（浏览）展示 ， 需要设置内容类型和编码（默认是ISO-8859-1编码），英文编码，中文在这个编码下乱码
        resp.setHeader("Content-Type","text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        //接收参数
        String uname = req.getParameter("username");
        String pwd = req.getParameter("password");
        System.out.println("收到参数值：" + uname);
        //显示在网页上
        PrintWriter writer = resp.getWriter();
        if ("admin".equals(uname) && "123456".equals(pwd)){
            writer.write("登陆成功,欢迎您：" + uname);
            req.setAttribute("username",uname);
            req.getRequestDispatcher("/testSession").forward(req,resp);
        }else {
            writer.write("登陆失败！");
        }

    }
}
