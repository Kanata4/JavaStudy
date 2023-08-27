package com.geekaca.web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.geekaca.pojo.User;
import com.geekaca.service.UserService;
import com.geekaca.util.JwtUtil;
import com.geekaca.util.Result;

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

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        System.out.println(s);
        //{"uname":"test","pwd":"123"}
        //把一个JSON 的字符串 解析，提取其中各个属性的值   非常像 Hash Map
        JSONObject jsonObject = JSON.parseObject(s, JSONObject.class);
        Object uname = jsonObject.get("uname");
        System.out.println(uname + " pass:" + jsonObject.get("pwd"));
        Object pwd = jsonObject.get("pwd");
        User user = userService.isLoginOk(uname.toString(), pwd.toString());
        resp.setHeader("Content-Type", "text/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        Result result = new Result();
        if (user != null){
            //登陆成功
            /**
             * 生成token，返回给前端
             * 还要返回用户的type的类型
             */
            String token = JwtUtil.createToken(user);
            result.setCode(200);
            //密码清空
            user.setPassword("");
            user.setToken(token);
            result.setData(user);
            result.setMsg("登陆成功");
        }else{
            result.setCode(400);
            result.setMsg("登陆成功");
        }
        String jsonString = JSON.toJSONString(result);
        writer.write(jsonString);
        writer.flush();

    }
}
