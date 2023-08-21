package com.geekaca.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("servletContext 初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
