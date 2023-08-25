package com.geekaca.web.servlet;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.interfaces.Claim;
import com.geekaca.pojo.Brand;
import com.geekaca.service.BrandService;
import com.geekaca.util.JwtUtil;
import com.geekaca.util.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(urlPatterns = "/addServlet")
public class AddServlet extends HttpServlet {

    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //1. 接收品牌数据 JSON格式 读取消息体数据
        BufferedReader br = req.getReader();
        String line = br.readLine();//json字符串

        //转换为Brand对象
        Brand brand = JSON.parseObject(line, Brand.class);
        StringBuilder msg = new StringBuilder();
        if (brand.getStatus() == null || "".equals(brand.getStatus())){
            msg.append("状态不能为空<br>");
        }
        if (brand.getBrandName() == null || "".equals(brand.getBrandName().trim())){
            msg.append("品牌名不能为空<br>");
        }
        resp.setHeader("Content-Type", "text/json;charset=utf-8");
        // 直接返回给前端  ,返回给前端的统一的都是JSON
        PrintWriter writer = resp.getWriter();
        if (!"".equals(msg.toString())) {
            //返回code 400 代表错误  msg:
            Result result = new Result();
            result.setCode(400);
            result.setMsg(msg.toString());
            String s = JSON.toJSONString(result);
            writer.write(s);
            writer.flush();
            return;
        }

        //2. 调用service添加
        int added = brandService.add(brand);

        //3. 响应成功的标识
        if (added > 0) {
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
