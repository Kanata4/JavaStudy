package com.geekaca.web.servlet;

import com.geekaca.web.mapper.UserMapper;
import com.geekaca.web.pojo.User;
import com.geekaca.web.utils.SqlUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.geekaca.web.utils.SqlUtil.openSession;

@WebServlet(urlPatterns = "/register2")
public class RegServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type","text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirm = req.getParameter("confirm");
        String gender = req.getParameter("gender");

        String[] hobbies = req.getParameterValues("hobby");
        String city = req.getParameter("city");
        String desc = req.getParameter("desc");

        if(password == null || confirm == null){
            //不允许为空
            writer.write("密码不允许为空！");
            return;
        }
        if (!password.equals(confirm)){
            writer.write("两次密码不一致！");
            return;
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //1.检查占用
        boolean isUsed = isAlreadyUsed(username);
        if (isUsed){
            writer.write("用户名：" + username + "已经被占用了！");
            writer.flush();
            return;
        }
        //2. insert
        //调用mybatis
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < hobbies.length; i++) {
            switch (hobbies[i]){
                case "1":
                    stringBuilder.append("旅游,");
                    break;
                case "2":
                    stringBuilder.append("电影,");
                    break;
                case "3":
                    stringBuilder.append("游戏,");
                    break;
            }
        }
        user.setHobby(stringBuilder.toString());
        //String -> int
        user.setGender(Integer.parseInt(gender));
        user.setCity(city);
        user.setDesc(desc);
        int rs = addUser(user);
        if(rs > 0){
            writer.write("注册成功<br/>");
            writer.write("<a href=\"login.html\">前往登录</a>");
        }else {
            writer.write("注册失败");
        }

    }

    /**
     * 用户名是否被占用
     * @param userName
     * @return
     */
    private boolean isAlreadyUsed(String userName){
        SqlSession sqlSession = SqlUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.selectByUname(userName);
        if(result > 0){
            //用户名已经被占用了
            return true;
        }else{
            return false;
        }
    }

    //增加用户
    private int addUser(User user){
        SqlSession sqlSession = SqlUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //sql 语句返回的int 含义：你发送的sql 影响了多少条记录{insert,update,delete}
        int rs = userMapper.insertUserWithDetail(user);
        return rs;
    }


}
