package com.geekaca.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        servletRequest.setCharacterEncoding("UTF8");
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        String uri = req.getRequestURI();
        //2.判断是否包含登录相关资源路径，排除登录和验证码
        if (uri.contains("/login.jsp") || uri.contains("/login") || uri.contains("/code")){
            //用户就是想登录
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            if (user == null){
                req.setAttribute("err","请先登录！");
                req.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
            } else {
                //过滤器链 放行请求
                filterChain.doFilter(servletRequest,servletResponse);
//            req.getRequestDispatcher("/main.jsp").forward(servletRequest,servletResponse);
            }
        }
    }
}
