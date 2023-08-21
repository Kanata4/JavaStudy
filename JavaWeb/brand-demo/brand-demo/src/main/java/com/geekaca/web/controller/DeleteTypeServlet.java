package com.geekaca.web.controller;

import com.geekaca.web.service.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteType")
public class DeleteTypeServlet extends HttpServlet {
    private TypeService typeService = new TypeService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        if (id == null || "".equals(id.trim())){
            return;
        }
        int deleted = typeService.deleteType(Integer.parseInt(id));
        if (deleted > 0){
            req.setAttribute("info","删除成功");
            req.getRequestDispatcher("/allType").forward(req,resp);
        }
    }
}
