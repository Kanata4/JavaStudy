package com.geekaca.ssm.service.impl;

import com.geekaca.ssm.dao.BrandMapper;
import com.geekaca.ssm.domain.Brand;
import com.geekaca.ssm.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> getAll() {
        List<Brand> all = brandMapper.selectAll();
        return all;
    }
}
