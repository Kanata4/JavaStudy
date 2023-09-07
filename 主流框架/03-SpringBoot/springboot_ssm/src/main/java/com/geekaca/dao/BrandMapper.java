package com.geekaca.dao;

import com.geekaca.domain.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// TODO:添加@Mapper
@Mapper
public interface BrandMapper {

    //增加
    public int save(Brand brand);
    //修改
    public int update(Brand brand);
    //删除
    public int delete(Integer id);
    //查询
    public Brand getById(Integer id);
    //查询所有
    List<Brand> getAll(@Param("start") Integer pageNo, @Param("pageSize") Integer pageSize);
    //根据品牌名查询
    List<Brand> getByBrandName(String brandName);
;
}
