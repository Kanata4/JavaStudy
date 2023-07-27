package com.geekaca.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.geekaca.jdbc.pojo.Brand;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestBrand {
    public void main(String[] args) throws Exception {
//        testSelectALl();
//        testAdd();
//        testUpdate();
        testDeleteById();
    }

    //@Test
    public void testSelectALl() throws Exception {
        //1.获取Connection
        //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\dev\\workspace\\code\\JDBC\\studyJDBC\\studyJDBC\\druid.properties"));
        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5. 获取数据库连接 Connection
        Connection conn = dataSource.getConnection();
        //2.定义SQL
        String sql = "select * from tb_brand;";
        //3.获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //4.设置参数
        //5.执行SQL
        ResultSet rs = pstmt.executeQuery();
        //6.处理结果 List<Brand> 封装Brand对象，装载List集合
        Brand brand = null;
        List<Brand> brands = new ArrayList<>();
        while (rs.next()) {
            //获取数据
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");
            //封装Brand对象
            brand = new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);

            //装载集合
            brands.add(brand);
        }
//        System.out.println(brands);
        for (int i = 0; i < brands.size(); i++) {
            System.out.println(brands.get(i) + "\n");
        }
        //7.释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }

    //@Test
    public void testAdd() throws Exception {
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1;
        String description = "绕地球一圈";
        int status = 1;

        //1.获取Connection
        //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\dev\\workspace\\code\\JDBC\\studyJDBC\\studyJDBC\\druid.properties"));
        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //5.获取数据库连接 connection
        Connection conn = dataSource.getConnection();
        //2.定义SQL
        String sql = "insert into tb_brand(brand_name,company_name,ordered,description,status) values(?,?,?,?,?);";
        //3.获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //4.设置参数
        pstmt.setString(1, brandName);
        pstmt.setString(2, companyName);
        pstmt.setInt(3, ordered);
        pstmt.setString(4, description);
        pstmt.setInt(5, status);

        //5.执行SQL
        int count = pstmt.executeUpdate();//影响的行数
        //6. 处理结果
        System.out.println(count > 0);

        //7.释放资源
        pstmt.close();
        conn.close();
    }

    //@Test
    public void testUpdate() throws Exception {
        //接收页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1000;
        String description = "绕地球三圈";
        int status = 1;
        int id = 4;

        //1.获取Connection
        //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\dev\\workspace\\code\\JDBC\\studyJDBC\\studyJDBC\\druid.properties"));
        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //5.获取数据库连接 Connection
        Connection conn = dataSource.getConnection();
        //2.定义SQl
        String sql = "update tb_brand\n" +
                "set brand_name = ?,company_name = ?,ordered = ?,description = ?,status = ?\n" +
                "where id =?;";

        //3.获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4.设置参数
        pstmt.setString(1, brandName);
        pstmt.setString(2, companyName);
        pstmt.setInt(3, ordered);
        pstmt.setString(4, description);
        pstmt.setInt(5, status);
        pstmt.setInt(6, id);

        //5.执行SQl
        int count = pstmt.executeUpdate();//影响的行数
        //6.处理结果
        System.out.println(count > 0);

        //7.释放资源
        pstmt.close();
        conn.close();
    }

    @Test
    public void testDeleteById() throws Exception {
        //接受页面提交的参数
        int id = 4;
        //1.获取Connection
        //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\dev\\workspace\\code\\JDBC\\studyJDBC\\studyJDBC\\druid.properties"));
        //4. 获取连接池对象
        DataSource dataSource =
                DruidDataSourceFactory.createDataSource(prop);
        //5. 获取数据库连接 Connection
        Connection conn = dataSource.getConnection();
        //2. 定义SQL
        String sql = "delete from tb_brand where id = ?;";
        //3. 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //4. 设置参数
        pstmt.setInt(1, id);
        //5. 执行SQL
        int count = pstmt.executeUpdate(); // 影响的行数
        //6. 处理结果
        System.out.println(count > 0);
        //7. 释放资源
        pstmt.close();
        conn.close();
    }
}
