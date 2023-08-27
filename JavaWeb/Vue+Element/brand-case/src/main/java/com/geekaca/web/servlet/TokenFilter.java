package com.geekaca.web.servlet;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.interfaces.Claim;
import com.geekaca.constants.BrandConstant;
import com.geekaca.util.JwtUtil;
import com.geekaca.util.Result;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebFilter("/*")
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String requestURI = req.getRequestURI();
        System.out.println("doFilter...");

        Result result = new Result();

        if (requestURI.contains("addServlet") || requestURI.contains("deleteServlet")
        || requestURI.contains("updateServlet")){
            //修改类的操作，需要登陆校验 ，需要是已经登陆的用户
            //要求 针对这些接口的请求，要携带token  header中
            String token = req.getHeader("token");
            if (token == null || "".equals(token.trim())){
                //非法访问 ,拒绝访问
                result.setCode(403);
                result.setMsg("非法访问");
                String s = JSON.toJSONString(result);
                resp.setHeader("Content-Type", "text/json;charset=utf-8");
                // 直接返回给前端  ,返回给前端的统一的都是JSON
                PrintWriter writer = resp.getWriter();
                writer.write(s);
                return;
            }else{
                try {
                    Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);

                    if (stringClaimMap == null){
                        result.setCode(403);
                        result.setMsg("非法访问");
                        String s = JSON.toJSONString(result);
                        resp.setHeader("Content-Type", "text/json;charset=utf-8");
                        // 直接返回给前端  ,返回给前端的统一的都是JSON
                        PrintWriter writer = resp.getWriter();
                        writer.write(s);
                        return;
                    }
                    Claim userType = stringClaimMap.get("userType");
                    Integer uType = userType.asInt();
                    //非管理员 禁止
                    if (uType != BrandConstant.USER_TYPE_ADMIN){
                        result.setCode(403);
                        result.setMsg("非法访问");
                        String s = JSON.toJSONString(result);
                        resp.setHeader("Content-Type", "text/json;charset=utf-8");
                        // 直接返回给前端  ,返回给前端的统一的都是JSON
                        PrintWriter writer = resp.getWriter();
                        writer.write(s);
                        return;
                    }
                } catch (Exception e) {
                    //token 解析报错  比如，过期 ，或者密文错误
                    e.printStackTrace();
                    result.setCode(403);
                    result.setMsg("非法访问");
                    String s = JSON.toJSONString(result);
                    resp.setHeader("Content-Type", "text/json;charset=utf-8");
                    // 直接返回给前端  ,返回给前端的统一的都是JSON
                    PrintWriter writer = resp.getWriter();
                    writer.write(s);
                    return;
                }

            }
        }
        //放行请求
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
