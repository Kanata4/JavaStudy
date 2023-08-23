package com.geekaca.mapper;

import com.geekaca.pojo.Brand;

import java.util.List;

public interface BrandMapper {

    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();

    /**
     * 添加数据
     * @param brand
     * @return
     */
    int add(Brand brand);

    List<Brand> search(Brand brand);

    int update(Brand brand);

    int delete(Integer id);

}
