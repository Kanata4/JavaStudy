package com.geekaca.jdbc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) throws Exception {
        //testAdd();
        //testSelect();
        //testSearch();
        testSelectDbemp();
    }

    public static void testSearch() throws Exception {
        //1.导入jar包
        // 2.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        // 3.获取数据库连接
        Connection con = DriverManager.getConnection(url, username, password);
        //4.获取预处理对象
        String sql="select * from account where name like ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        //5.传参并执行sql
        System.out.println("请输入：");
        Scanner sc = new Scanner(System.in);
        String keyword=sc.next();
        //后期是通过页面获取用户输入的关键词
        pstm.setObject(1,"%"+keyword+"%");
        //对关键词进行前后%的拼接
        ResultSet rs = pstm.executeQuery();
        // 6.解析结果集，模糊查询有可能查到很多条数据，所以定义集合存储
        List<Emp> empList=new ArrayList<>();
        while (rs.next()){
            Emp emp=new Emp();
            //通过rs根据字段名获取数据库表中的数据，然后把数据封装到Student对象中
            emp.setEmpName(rs.getString("name"));
            emp.setEmpMoney(rs.getInt("money"));
            //把当前的student对象存储到list集合中
            empList.add(emp); }
        //打印输出
        System.out.println(empList);
        //7.资源的释放
        if(rs!=null){
            rs.close();
        }if(pstm!=null){
            pstm.close();
        }if(con!=null){
            con.close();
        }
    }

    public static void testAdd() throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        Class.forName("com.mysql.jdbc.Driver");
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            //构造会话 用来发送sql语句
            String sql = "insert into account(name,money) values(?,10000)";
            PreparedStatement pstm = connection.prepareStatement(sql);
            System.out.println("请输入：");
            Scanner sc = new Scanner(System.in);
            String name = sc.next();
            pstm.setObject(1,name);
            pstm.executeUpdate();
            pstm.close();
            connection.close();
            //你发送的sql语句，影响了多少条记录
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void testSelect() {
        //1,加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&characterEncoding=utf8";
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
            //6， 对结果进行遍历   当还有更多的记录时候，返回true
            while (resultSet.next()) {
//            id, name, money
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double money = resultSet.getDouble("money");
                System.out.println("id:" + id + " name: " + name + " money:" + money);
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

    public static void testSelectDbemp() {
        //1,加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/dbemp?useSSL=false&characterEncoding=utf8";
            String username = "root";
            String password = "123456";
            //2, 建立连接
            Connection connection = DriverManager.getConnection(url, username, password);
            // 3, 构造sql
            String sql = "SELECT \n" +
                    "    emp_name, joindate, salary, height, dept_name\n" +
                    "FROM\n" +
                    "    dongtu_emp\n" +
                    "        LEFT OUTER JOIN\n" +
                    "    dongtu_dept ON dongtu_dept.dept_id = dongtu_emp.dept_id";
            //4， 构造会话  用来发送sql语句
            Statement stmt = connection.createStatement();
            //5， 发送sql，获得结果集
            ResultSet resultSet = stmt.executeQuery(sql);
            //6， 对结果进行遍历   当还有更多的记录时候，返回true
            while (resultSet.next()) {
                String emp_name = resultSet.getString("emp_name");
                Date joindate =  resultSet.getDate("joindate");
                int salary = resultSet.getInt("salary");
                double height = resultSet.getDouble("height");
                String dept_name = resultSet.getString("dept_name");
                System.out.println("员工姓名:" + emp_name + " 入职日期: " + joindate + " 工资:" + salary +
                        " 身高：" + height + "部门名字：" + dept_name);
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
