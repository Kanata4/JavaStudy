package com.geekaca.web.controller;

import com.geekaca.web.pojo.Type;
import com.geekaca.web.service.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/addType")
public class AddTypeServlet extends HttpServlet {
    private TypeService typeService = new TypeService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeName = req.getParameter("typeName");
        Type type = new Type();
        type.setTypeName(typeName);
        int i = typeService.addType(type);
        if (i > 0){
            resp.sendRedirect(req.getContextPath() + "/allType");
        } else {
            req.setAttribute("err","添加失败");
            req.getRequestDispatcher("/addType").forward(req,resp);
        }


    }
}
