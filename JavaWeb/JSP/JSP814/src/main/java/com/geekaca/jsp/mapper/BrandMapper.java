package com.geekaca.jsp.mapper;

import com.geekaca.jsp.pojo.Brand;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();

    int insertBrand(Brand brand);

    Brand selectById(int id);

    void updateBrand(Brand brand);

    void deleteBrand(int id);
}
