package com.geekaca.web.controller;

import com.geekaca.web.pojo.Brand;
import com.geekaca.web.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/add")
public class AddServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String brandName = req.getParameter("brandName");
        String companyName = req.getParameter("companyName");
        String ordered = req.getParameter("ordered");
        String description = req.getParameter("description");
        String status = req.getParameter("status");
        String typeId = req.getParameter("typeId");
        //todo:调用Mybatis，insert DB
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));
        brand.setTypeId(Integer.parseInt(typeId));
        int added = brandService.addBrand(brand);
        if (added > 0){
            //todo:跳转到查询所有的界面
            //需要先 跳转到servlet 查询数据，
            //目标，跳转到另一个servlet, 不传值直接用重定向，如果要传多个，比如集合，要用forward
            req.getAttribute("types");
            resp.sendRedirect(req.getContextPath() + "/selectAll");
        } else {
            //提示出错
            req.setAttribute("err","新增失败");
            //请求转发，浏览器地址栏不会变化
            req.getRequestDispatcher("/addBrand.jsp").forward(req,resp);
        }
    }
}
