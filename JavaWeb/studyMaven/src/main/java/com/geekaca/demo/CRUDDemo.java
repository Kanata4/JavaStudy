package com.geekaca.demo;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CRUDDemo {
    public static void main(String[] args) throws Exception {

        //1， 加载配置文件
        Properties prop = new Properties();
        InputStream ips = CRUDDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        prop.load(ips);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        /**
         * 对品牌表  CRUD
         *
         */
        Brand brand = new Brand(0, "老干妈",
                "老干妈科技游侠公司", 1, "国民女神", 1);
//        try {
//            int updated = addBrand(brand);
//            System.out.println("收到影响的记录条数:" + updated);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //查询
//        Brand brd = getById(dataSource, 2);
//        if (brd == null){
//            System.out.println("没有找到数据");
//        }else{
//            //会自动调用brd.toString()
//            System.out.println("找到数据: " + brd);
//        }
        //更新
//        Brand brand2 = new Brand(1, "BYD",
//                "比亚迪", 1, "混动技术", 1);
//        int updateBrand = updateBrand(dataSource, brand2);
//        System.out.println("更新了：" +updateBrand);
        //删除
//        int deleted = deleteById(dataSource, 4);
//        System.out.println("删除了 多少条: " + deleted);
        //模糊查询

//        Brand brd = getByBrandName(dataSource, "%三%");
        List brd = getByBrandName(dataSource, "三");

        if (brd == null){
            System.out.println("没有找到数据");
        }else{
            //会自动调用brd.toString()
            System.out.println("找到数据: " + brd);
        }
    }

    private static List<Brand> getByBrandName(DataSource dataSource, String keywords){
        List<Brand> brandList = new ArrayList<>();
        try(Connection conn = dataSource.getConnection();){
            String sql = "select * from tb_brand where brand_name like ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + keywords + "%");
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String brandName = rs.getString("brand_name");
                String companyName = rs.getString("company_name");
                String description = rs.getString("description");
                int status = rs.getInt("status");
                Brand brand = new Brand(id, brandName, companyName, rs.getInt("ordered"), description, status);
                brandList.add(brand);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return brandList;
    }

    /**
     * 增加品牌数据
     *
     * @param brand
     * @return
     */
    private static int addBrand(Brand brand) throws Exception {
        //建立连接
        //1， 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("studyJDBC/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        try (
//                int i = 0;//没有close()方法，不能放进来
                //try-with-resource  ，能够写在小括号中的代码，都是能够调用close()
                //后面会自动调用close(),省去了咱们自己手动调用close()关闭
                Connection conn = dataSource.getConnection();
        ) {
            String sql = "insert into tb_brand(brand_name, company_name, ordered, description, status)" +
                    " values(?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, brand.getBrandName());
            pstmt.setString(2, brand.getCompanyName());
            pstmt.setInt(3, brand.getOrdered());
            pstmt.setString(4, brand.getDescription());
            pstmt.setInt(5, brand.getStatus());
            int updated = pstmt.executeUpdate();
            return updated;
        }
    }

    /**
     * 根据id查询品牌信息
     *
     * @param id
     * @return
     */
    private static Brand getById(DataSource dataSource, int id) {
        try(Connection conn = dataSource.getConnection();){
            String sql = "select * from tb_brand where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int bid = rs.getInt("id");
                String brandName = rs.getString("brand_name");
                String companyName = rs.getString("company_name");
                String description = rs.getString("description");
                int status = rs.getInt("status");
                Brand brand = new Brand(bid, brandName, companyName, rs.getInt("ordered"), description, status);
                return brand;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * 根据id 更新 数据库中某个品牌数据的信息
     *
     * @param brand
     * @return
     */
    private static int updateBrand(DataSource dataSource, Brand brand) {
        try(Connection conn = dataSource.getConnection();){
            String sql = "update tb_brand set  brand_name = ?, company_name=?, ordered=?, description=?, status=? where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, brand.getBrandName());
            pstmt.setString(2, brand.getCompanyName());
            pstmt.setInt(3, brand.getOrdered());
            pstmt.setString(4, brand.getDescription());
            pstmt.setInt(5, brand.getStatus());
            pstmt.setInt(6, brand.getId());
            int updated = pstmt.executeUpdate();
            return updated;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    /**
     * 根据id 删除数据
     *
     * @param id
     * @return >0 删除成功 ，否则删除失败
     */
    private static int deleteById(DataSource dataSource, int id) {
        try(Connection conn = dataSource.getConnection();){
            String sql = "delete from tb_brand where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            int i = pstmt.executeUpdate();//增加，删除，修改，都属于更新类的语句，都可以用executeUpdate()执行
            return i;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
