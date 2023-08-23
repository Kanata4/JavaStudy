package com.geekaca.web.servlet;

import com.alibaba.fastjson.JSON;
import com.geekaca.pojo.Brand;
import com.geekaca.service.BrandService;
import com.geekaca.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/deleteServlet")
public class DeleteServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteServlet.class);
    private BrandService brandService = new BrandService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type", "text/json;charset=utf-8");
        //1. 接收品牌数据 JSON格式 读取消息体数据
        String id = req.getParameter("id");
        //转换为Brand对象
        LOGGER.info("service : ", id);
        if (id == null){
            return;
        }
        // 直接返回给前端  ,返回给前端的统一的都是JSON
        PrintWriter writer = resp.getWriter();
        //2. 调用service添加
        int deleted = brandService.delete(Integer.parseInt(id));
        //3. 响应成功的标识
        if (deleted > 0) {
            // 返回 code 200
            Result result = new Result();
            result.setCode(200);
            String s = JSON.toJSONString(result);
            writer.write(s);
            writer.flush();
        } else {
            // 返回code  400 代表失败
            Result result = new Result();
            result.setCode(400);
            String s = JSON.toJSONString(result);
            writer.write(s);
            writer.flush();
            return;
        }
    }
}
