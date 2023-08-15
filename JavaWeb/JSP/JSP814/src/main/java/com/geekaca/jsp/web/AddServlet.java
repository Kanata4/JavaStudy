package com.geekaca.jsp.web;

import com.geekaca.jsp.pojo.Brand;
import com.geekaca.jsp.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addBrand")
public class AddServlet extends HttpServlet {
    //成员变量  ，只创建一个对象，后续请求都使用同一个对象
    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String brandName = req.getParameter("brandName");
        String companyName = req.getParameter("companyName");
        String description = req.getParameter("description");
        String ordered = req.getParameter("ordered");
        String status = req.getParameter("status");
        StringBuilder msg = new StringBuilder();
        if ((status == null || "".equals(status.trim()))){
            msg.append("状态不能空<br>");
        }
        if (brandName == null || "".equals(brandName.trim())){
            msg.append("品牌名不能为空<br>");
        }
        if (!"".equals(msg.toString())){
            req.setAttribute("error",msg.toString());
            //请求转发，浏览器地址局域栏不会变化
            req.getRequestDispatcher("/addBrand.jsp").forward(req,resp);
            return;
        }

        //todo:调用Mybatis，insert DB
        Brand brand = new Brand(null, brandName, companyName, Integer.parseInt(ordered), description, Integer.parseInt(status));
        int added = brandService.addBrand(brand);
        if (added > 0){
            //todo:跳转到查询所有的界面
            //需要先 跳转到servlet 查询数据，
            //目标，跳转到另一个servlet, 不传值直接用重定向，如果要传多个，比如集合，要用forward
            resp.sendRedirect("/JSP814/selectAll");
        }else {
            //提示出错
            req.setAttribute("error","新增失败");
            //请求转发，浏览器地址栏不会变化
            req.getRequestDispatcher("/addBrand.jsp").forward(req,resp);
        }
    }
}
