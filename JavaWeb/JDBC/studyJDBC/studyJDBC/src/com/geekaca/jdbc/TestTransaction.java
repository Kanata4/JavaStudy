package com.geekaca.jdbc;

import java.sql.*;

public class TestTransaction {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * JDBC 事务操作
         *
         * 转账
         */
        transferMoney();
    }

    private static void transferMoney() throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false&characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        Class.forName("com.mysql.jdbc.Driver");
        String sql1 = "update  account set money = money - 500 where id = 1";
        String sql2 = "update  account set money = money - 500 where id = 2";
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql1);
//            int i = 9/0;
            stmt.executeUpdate(sql2);
//            connection.commit();
//            connection.rollback();
            stmt.close();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
}
