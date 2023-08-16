package com.geekaca.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/test")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Cookie
//        Cookie cookie = new Cookie("uname","zhang");
        //针对中文，需要编码
        String zhangsan = URLEncoder.encode("张三", "UTF-8");
        Cookie cookie = new Cookie("uname",zhangsan);
        cookie.setMaxAge(60 * 60);// 一小时
        //告诉浏览器，给你一个cookie，你存起来
        resp.addCookie(cookie);
    }
}
