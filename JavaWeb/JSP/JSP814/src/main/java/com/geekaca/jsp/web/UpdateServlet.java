package com.geekaca.jsp.web;

import com.geekaca.jsp.pojo.Brand;
import com.geekaca.jsp.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateServlet")
public class UpdateServlet extends HttpServlet {
    private BrandService service = new BrandService();

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String brandName = req.getParameter("brandName");
        String companyName = req.getParameter("companyName");
        String ordered = req.getParameter("ordered");
        String description = req.getParameter("description");
        String status = req.getParameter("status");

        Brand brand = new Brand();
        brand.setId(Integer.parseInt(id));
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));

        int updated = service.updateBrand(brand);
        if (updated > 0){
            req.getRequestDispatcher("/selectAll").forward(req,res);
        } else {
            req.setAttribute("brd",brand);
            req.setAttribute("error","更新失败");
            //请求转发，浏览器地址不会变化
            req.getRequestDispatcher("/update.jsp").forward(req,res);
            return;
        }

    }
}
