package com.geekaca.ssm.dao;

import com.geekaca.ssm.domain.Brand;

import java.util.List;

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
    List<Brand> getAll();
    //根据品牌名查询
    List<Brand> getByBrandName(String brandName);
;
}
