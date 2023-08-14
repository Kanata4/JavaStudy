package com.geekaca.jsp.web;

import com.geekaca.jsp.pojo.Brand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/demo")
public class DemoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> brands = new ArrayList<Brand>();
        brands.add(new Brand(1,"三只松鼠","三只松鼠",100,"三只松鼠，好吃不上火",1));
        brands.add(new Brand(2,"优衣库","优衣库",200,"优衣库，服适人生",0));
        brands.add(new Brand(3,"小米","小米科技有限公司",1000,"为发烧而生",1));

        //存储到request域中 放入request作用域的 要引用数据类型
        req.setAttribute("brands",brands);
        req.setAttribute("status",1);
        //从servlet 转发到另一个Servlet或者jsp 请求范围

        //转发到el-demo.jsp
//        req.getRequestDispatcher("/el-demo.jsp").forward(req,resp);
//        req.getRequestDispatcher("/jstl-if.jsp").forward(req,resp);
        req.getRequestDispatcher("/jstl-foreach.jsp").forward(req,resp);

    }
}
