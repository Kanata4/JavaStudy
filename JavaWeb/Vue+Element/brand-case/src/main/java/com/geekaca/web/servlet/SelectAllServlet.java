package com.geekaca.web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.geekaca.pojo.Brand;
import com.geekaca.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 调用service查询
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
        List<Brand> brands = brandService.selectAll(pNo,pageSize);
        //单独执行一个查询，查询符合条件的总记录条数
        int allBrandsCount = brandService.getAllBrandsCount();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cnt",allBrandsCount);
        jsonObject.put("brands",brands);
        //直接返回给前端

        resp.setHeader("Content-Type", "text/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write(jsonObject.toJSONString());
        writer.flush();
    }
}
