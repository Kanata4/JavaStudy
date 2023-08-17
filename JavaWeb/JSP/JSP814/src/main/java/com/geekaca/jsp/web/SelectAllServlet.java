package com.geekaca.jsp.web;

import com.geekaca.jsp.pojo.Brand;
import com.geekaca.jsp.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/selectAll")
public class SelectAllServlet extends HttpServlet {
    private BrandService service = new BrandService();

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 检查用户是否登陆
         */
        HttpSession session = req.getSession();
        Object uname = session.getAttribute("uname");
        if(uname == null){
            //说明用户没有登陆
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        List<Brand> brands = service.selectAll();
        req.setAttribute("brands",brands);
        req.getRequestDispatcher("/brand.jsp").forward(req,resp);
    }
}
