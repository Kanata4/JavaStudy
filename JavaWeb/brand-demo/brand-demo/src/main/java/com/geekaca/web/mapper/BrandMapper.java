package com.geekaca.web.mapper;

import com.geekaca.web.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();

    int addBrand(Brand brand);

    Brand selectById(int id);

    int updateBrand(Brand brand);

    int deleteBrand(int id);

    List<Brand> selectByCompanyName(String brandName);
}
