package com.geekaca.web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
        BufferedReader br = new BufferedReader(new InputStreamReader(ips,"UTF-8"));
        String line = br.readLine();//json字符串
        System.out.println("line:" + line);
        //转换为Brand对象
        Brand brand = JSON.parseObject(line, Brand.class);

        //调用service查询
        String pageNo = req.getParameter("pageNo");
        String cntPerPage = req.getParameter("cntPerPage");
        if (pageNo == null){
            pageNo = "1";
        }
        if (cntPerPage == null){
            cntPerPage = "10";
        }
        int pNo = Integer.parseInt(pageNo);
        int pageSize = Integer.parseInt(cntPerPage);
        //自动装箱 int->Integer
        //查询这一页的数据
        List<Brand> brands = brandService.search(pNo,pageSize,brand);
        //单独执行一个查询，查询符合条件的总记录条数
        int count = brandService.queryBrandsCount(pNo,pageSize,brand);
        /**
         * 查询接口返回的数据 格式
         * 和 显示所有数据 接口 格式一致
         *
         * 前端可以用同一套代码 处理显示
         */
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cnt",count);
        jsonObject.put("brands",brands);
        //直接返回给前端

        resp.setHeader("Content-Type", "text/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write(jsonObject.toJSONString());
        writer.flush();
    }
}
