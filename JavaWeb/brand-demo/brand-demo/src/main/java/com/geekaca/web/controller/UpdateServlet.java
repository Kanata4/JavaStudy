package com.geekaca.web.controller;

import com.geekaca.web.pojo.Brand;
import com.geekaca.web.service.BrandService;
import com.geekaca.web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String brandName = req.getParameter("brandName");
        String companyName = req.getParameter("companyName");
        String ordered = req.getParameter("ordered");
        String description = req.getParameter("description");
        String status = req.getParameter("status");
        String typeId = req.getParameter("typeId");

        Brand brand = new Brand();
        brand.setId(Integer.parseInt(id));
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));
        brand.setTypeId(Integer.parseInt(typeId));

        int updated = brandService.updateBrand(brand);
        if (updated > 0){
            req.setAttribute("info","更新成功");
            req.getRequestDispatcher("/selectAll").forward(req,resp);
        } else {
            req.setAttribute("error","更新失败");
            //请求转发，浏览器地址不会变化
            req.getRequestDispatcher("/updateBrand.jsp").forward(req,resp);
            return;
        }
    }
}
