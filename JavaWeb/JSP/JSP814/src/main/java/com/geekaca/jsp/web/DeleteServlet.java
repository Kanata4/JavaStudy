package com.geekaca.jsp.web;

import com.geekaca.jsp.pojo.Brand;
import com.geekaca.jsp.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteBrand")
public class DeleteServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteServlet.class);
    private BrandService brandService = new BrandService();

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        LOGGER.info("service : ", id);
        if (id == null || "".equals(id.trim())){
            return;
        }
        int deleteBrand = brandService.deleteBrand(Integer.parseInt(id));
        req.getRequestDispatcher("/selectAll").forward(req,res);
    }
}
