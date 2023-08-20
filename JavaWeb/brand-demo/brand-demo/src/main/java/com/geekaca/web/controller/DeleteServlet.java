package com.geekaca.web.controller;

import com.geekaca.web.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        if (id == null || "".equals(id.trim())){
            return;
        }
        int deleted = brandService.deleteBrand(Integer.parseInt(id));
        if (deleted > 0){
            req.setAttribute("info","删除成功");
            req.getRequestDispatcher("/selectAll").forward(req,resp);
        }
    }
}
