package com.geekaca.mapper;

import com.geekaca.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {

    /**
     * 查询所有
     * @return
     */


    //单独的参数 要加注解
    List<Brand> selectAll(@Param("start") Integer pageNo,@Param("pageSize") Integer pageSize);

    /**
     * 添加数据
     * @param brand
     * @return
     */
    int add(Brand brand);

    List<Brand> search(@Param("start")Integer pageNo, @Param("pageSize") Integer pageSize, @Param("brand") Brand brand);

    int update(Brand brand);

    int delete(Integer id);

    int selectAllCount();

}
