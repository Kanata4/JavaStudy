package com.geekaca.jdbc;

import com.geekaca.jdbc.pojo.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestORM {
    public static void main(String[] args) {
        /**
         * Object  Relationship Mapping
         * 对象    关系            映射
         * Java    关系数据库Mysql
         */
        testSelect();
    }

    public static void testSelect() {
        //1,加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/testdb?characterEncoding=utf8";
            String username = "root";
            String password = "123456";
            //2, 建立连接
            Connection connection = DriverManager.getConnection(url, username, password);
            // 3, 构造sql
            String sql = "select * from account";
            //4， 构造会话  用来发送sql语句
            Statement stmt = connection.createStatement();
            //5， 发送sql，获得结果集
            ResultSet resultSet = stmt.executeQuery(sql);
            List<Account> accountList = new ArrayList<>();
            //6， 对结果进行遍历   当还有更多的记录时候，返回true
            while (resultSet.next()) {
//            id, name, money
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                double money = resultSet.getDouble("money");
//                System.out.println("id:" + id + " name: " + name + " money:" + money);
                //把当前这一行记录的数据 保存在一个对象中
                Account acc = new Account();
                acc.setId(id);
                acc.setName(name);
                acc.setMoney(money);
                accountList.add(acc);
            }
            //所有记录都被保存在集合中
            for (int i = 0; i < accountList.size(); i++) {
                System.out.println(accountList.get(i));
            }
            //7， 关闭
            resultSet.close();
            stmt.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
