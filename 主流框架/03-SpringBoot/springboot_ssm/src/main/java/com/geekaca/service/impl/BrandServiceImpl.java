package com.geekaca.service.impl;

import com.geekaca.dao.BrandMapper;
import com.geekaca.domain.Brand;
import com.geekaca.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    //调用接口 @Service @Autowired 自动装配
    private BrandMapper brandMapper;

    public int save(Brand brand) {
        int save = brandMapper.save(brand);
        return save;
    }

    public int update(Brand brand) {
        int update = brandMapper.update(brand);
        return update;
    }

    public int delete(Integer id) {
        int delete = brandMapper.delete(id);
        return delete;
    }

    public Brand getById(Integer id) {
        return brandMapper.getById(id);
    }

    public List<Brand> getAll(Integer pageNo, Integer pageSize) {
        int start = (pageNo - 1) * pageSize;
        return brandMapper.getAll(start,pageSize);
    }

    public List<Brand> getByBrandName(Brand brand) {
        String brandName = brand.getBrandName();
        return brandMapper.getByBrandName(brandName);
    }
}
