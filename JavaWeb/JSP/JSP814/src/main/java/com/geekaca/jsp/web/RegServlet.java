package com.geekaca.jsp.web;

import com.geekaca.jsp.service.BrandService;
import com.geekaca.jsp.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type","text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        /**
         * 接收用户名
         * 密码
         * 二次密码
         * 执行注册
         */
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");
        //验证码逻辑 需要检验用户输入的验证码 和刚刚生成的是否一致
        HttpSession session  = req.getSession();
        String code = (String)session.getAttribute("code");
        if(code != null && code.equals(checkCode)){
            //验证码正确
            int added = userService.addUser(username, password);
            if (added > 0){
                //todo:跳转到查询所有的界面
                //需要先 跳转到登陆界面
                //目标，跳转到另一个servlet, 不传值直接用重定向，如果要传多个，比如集合，要用forward
                req.setAttribute("info","注册成功");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }else {
                //提示出错
                req.setAttribute("error","注册失败");
                //请求转发，浏览器地址栏不会变化
                req.getRequestDispatcher("/register.jsp").forward(req,resp);
            }
        }else{
            //验证码错误
            req.setAttribute("err","验证码错误，注册失败");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
        }
    }
}
