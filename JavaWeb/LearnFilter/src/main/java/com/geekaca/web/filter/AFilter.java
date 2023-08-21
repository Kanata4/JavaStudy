package com.geekaca.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter(urlPatterns = "/*")
public class AFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("AFilter ===========");
        //统一设置，就不用每个servlet单独设置了
        servletRequest.setCharacterEncoding("UTF8");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
