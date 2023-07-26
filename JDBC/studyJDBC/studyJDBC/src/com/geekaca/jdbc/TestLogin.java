package com.geekaca.jdbc;

import java.sql.*;
import java.util.Scanner;

public class TestLogin {
    public static void main(String[] args) throws ClassNotFoundException {
        checkLogin("Tom","tom888");
    }

    private static boolean checkLogin(String uname,String pass) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false&characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        Class.forName("com.mysql.jdbc.Driver");
        boolean isLoginOk = false;
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement stmt = connection.createStatement();
            //构造会话 用来发送sql语句
            String sql = "SELECT count(*) as cnt FROM t_user where name = '" + uname + "' and pwd = '" + pass + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int cnt = rs.getInt("cnt");
                if(cnt > 0){
                    System.out.println("登录成功");
                    isLoginOk = true;
                }else{
                    System.out.println("登陆失败");
                    isLoginOk = false;
                }
            }
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return isLoginOk;
    }
}
