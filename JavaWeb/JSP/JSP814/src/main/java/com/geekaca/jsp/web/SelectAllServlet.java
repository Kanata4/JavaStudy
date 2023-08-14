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

@WebServlet(urlPatterns = "/selectAll")
public class SelectAllServlet extends HttpServlet {
    private BrandService service = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> brands = service.selectAll();
        req.setAttribute("brands",brands);
        req.getRequestDispatcher("/brand.jsp").forward(req,resp);
    }
}
