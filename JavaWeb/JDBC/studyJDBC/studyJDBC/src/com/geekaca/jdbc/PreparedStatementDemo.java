package com.geekaca.jdbc;

import java.sql.*;

public class PreparedStatementDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * 预编译会话
         */

        checkLogin("Tom3' or 1=1 and '1'='1", "123234234234234");
    }

    private static boolean checkLogin(String uname, String pass) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false&characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        Class.forName("com.mysql.jdbc.Driver");
        boolean isLoginOk = false;
        // 3, 构造sql    只要cnt > 0 说明登陆成功 ，否则登陆失败
        /**
         * ? 占位符
         *
         */
        String sql = "SELECT count(*) as cnt FROM t_user where name = ? and pwd = ? ";
        //1,加载驱动
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                //4， 构造会话  用来发送sql语句
                PreparedStatement pstmt = connection.prepareStatement(sql);
        ) {

            System.out.println(sql);
            //你发送的sql语句，影响了多少条记录
            /**
             * set 按问号的顺序 依次赋值
             */
            pstmt.setString(1, uname);
            pstmt.setString(2, pass);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int cnt = rs.getInt("cnt");
                if (cnt > 0){
                    System.out.println("登陆成功");
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
