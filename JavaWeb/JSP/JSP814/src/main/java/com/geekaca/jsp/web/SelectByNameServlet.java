package com.geekaca.jsp.web;

import com.geekaca.jsp.pojo.Brand;
import com.geekaca.jsp.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/selectByName")
public class SelectByNameServlet extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String brandName = req.getParameter("brandName");
        List<Brand> brands = service.selectByBrandName(brandName);
        req.setAttribute("brands",brands);
        req.getRequestDispatcher("/brand.jsp").forward(req,resp);

    }
}
