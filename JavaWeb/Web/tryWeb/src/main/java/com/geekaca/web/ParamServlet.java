package com.geekaca.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

/**
 * 接收参数
 */
@WebServlet(urlPatterns = "/testParam")
public class ParamServlet extends HelloServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("GBK");
        //设置网页显示中文
        response.setHeader("Content-type","text/html;charset=UTF-8");
        //1. 接受所有参数，放入集合
//        Map<String, String[]> parameterMap = req.getParameterMap();
//        parameterMap.forEach((key,strArr)->{
//            System.out.println("key:" + key);
//            System.out.println(Arrays.toString(strArr));
//        });
        //2.参数接收
        //单个值
        String uname =request.getParameter("username");
        String pwd = request.getParameter("password");
<<<<<<< HEAD
        System.out.println("username:" + uname + " password:" + pwd);
=======
        String adminName = "admin";
        String adminPwd = "123456";
        if (uname.equals(adminName) && pwd.equals(adminPwd)){
            System.out.println("username:" + uname + " password:" + pwd);
            System.out.println("登陆成功");
        } else {
            System.out.println("登陆失败！");
        }
>>>>>>> Web核心 Servlet 用户注册
        //多个值
        String[] hobbies = request.getParameterValues("hobby");
        if (hobbies != null){
            System.out.println("选中的爱好：");
            for (int i = 0; i < hobbies.length; i++) {
                System.out.println(hobbies[i]);
            }
        }
        //获取输出流 可以打印信息到浏览器

        PrintWriter writer = response.getWriter();
        writer.write("<b>你的用户名：" + uname + "</b>");
    }
}
