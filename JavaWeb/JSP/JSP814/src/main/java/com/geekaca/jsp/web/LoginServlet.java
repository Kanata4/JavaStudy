package com.geekaca.jsp.web;

import com.geekaca.jsp.pojo.User;
import com.geekaca.jsp.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
    private UserService userService = new UserService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //因为返回客户端（浏览）展示 ， 需要设置内容类型和编码（默认是ISO-8859-1编码），英文编码，中文在这个编码下乱码
        resp.setHeader("Content-Type","text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        //接收参数
        String uname = req.getParameter("username");
        String pwd = req.getParameter("password");
        String rememberMe = req.getParameter("rememberMe");

        boolean loginOk = userService.isLoginOk(uname, pwd);
        if (loginOk){
            //登陆成功
            HttpSession session = req.getSession();
            session.setAttribute("uname",uname);
            User user = new User();
            user.setUsername(uname);
            user.setPassword(pwd);
            session.setAttribute("uInfo",user);
            /**
             * 记住我
             */
            if (rememberMe != null && "on".equals(rememberMe)){
                //说明用户勾选了记住我
                /**
                 * todo: 把用户名和密码存入cookie
                 */
                Cookie cookie = new Cookie("uname",uname);
                Cookie cookie2 = new Cookie("pass",pwd);
                resp.addCookie(cookie);
                resp.addCookie(cookie2);
            }
            resp.sendRedirect(req.getContextPath()+"/selectAll");
        } else {
            req.setAttribute("err","登陆失败");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }

    }
}
