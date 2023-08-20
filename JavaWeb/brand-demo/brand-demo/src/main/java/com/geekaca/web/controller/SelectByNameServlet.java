package com.geekaca.web.controller;

import com.geekaca.web.pojo.Brand;
import com.geekaca.web.service.BrandService;
import org.apache.ibatis.annotations.Param;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/selectByName")
public class SelectByNameServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String brandName = req.getParameter("brandName");
        if(brandName != null && brandName != ""){
            List<Brand> brands = brandService.selectByBrandName(brandName);
            req.setAttribute("brands",brands);
            req.getRequestDispatcher("/allBrand.jsp").forward(req,resp);
        }else {
            req.setAttribute("err","输入有误！");
            req.getRequestDispatcher("/main.jsp").forward(req,resp);
        }

    }
}
