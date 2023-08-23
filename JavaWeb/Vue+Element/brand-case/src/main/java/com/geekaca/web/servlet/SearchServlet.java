package com.geekaca.web.servlet;

import com.alibaba.fastjson.JSON;
import com.geekaca.pojo.Brand;
import com.geekaca.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/searchServlet")
public class SearchServlet extends HttpServlet {

    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收数据 JSON格式 读取消息体数据
        ServletInputStream ips = req.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(ips));
        String line = br.readLine();//json字符串
        System.out.println("line:" + line);
        //转换为Brand对象
        Brand brand = JSON.parseObject(line, Brand.class);
        List<Brand> brands = brandService.search(brand);
        //转为JSON
        String jsonString = JSON.toJSONString(brands);
        resp.setHeader("Content-Type","text/json;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        //直接返回给前端
        PrintWriter writer = resp.getWriter();
        writer.write(jsonString);
        writer.flush();
    }
}
