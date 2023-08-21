package com.geekaca.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/update","/delete"})
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("My Filter 开始 doFilter......");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        Object uname = session.getAttribute("uname");

        //过滤器链 放行请求
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("从资源返回给前端之前......");
    }
}
