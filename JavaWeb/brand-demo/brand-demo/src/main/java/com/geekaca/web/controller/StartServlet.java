package com.geekaca.web.controller;

import com.geekaca.web.pojo.Type;
import com.geekaca.web.service.TypeService;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.List;

/**
 * loadOnStartup
 * 值 大于0 代表  启动web应用的时候，此servlet就会被创建
 */
@WebServlet(urlPatterns = "/start", loadOnStartup = 2)
public class StartServlet extends HttpServlet {
    private TypeService typeService = new TypeService();

    @Override
    public void init(ServletConfig config) throws ServletException {
        List<Type> types = typeService.selectAllType();
        ServletContext servletContext = config.getServletContext();
        servletContext.setAttribute("types", types);
        System.out.println("startServlet init.............");
    }

}
