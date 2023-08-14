package com.geekaca.jsp.mapper;

import com.geekaca.jsp.pojo.Brand;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();

}
