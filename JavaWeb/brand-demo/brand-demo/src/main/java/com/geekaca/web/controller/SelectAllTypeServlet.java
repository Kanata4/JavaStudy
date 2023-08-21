package com.geekaca.web.controller;

import com.geekaca.web.pojo.Type;
import com.geekaca.web.service.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/allType")
public class SelectAllTypeServlet extends HttpServlet {
    private TypeService typeService = new TypeService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Type> types = typeService.selectAllType();
        req.setAttribute("types","types");
        resp.sendRedirect(req.getContextPath() + "/allType.jsp");
    }
}
