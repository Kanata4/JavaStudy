package com.geekaca.web.controller;

import com.geekaca.web.pojo.Brand;
import com.geekaca.web.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/selectById")
public class SelectByIdServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Brand brand = brandService.selectById(Integer.parseInt(id));
        req.setAttribute("brand",brand);
        req.getRequestDispatcher("/updateBrand.jsp").forward(req,resp);
    }
}
