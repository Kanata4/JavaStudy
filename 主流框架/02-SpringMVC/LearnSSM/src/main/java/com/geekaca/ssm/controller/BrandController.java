package com.geekaca.ssm.controller;

import com.geekaca.ssm.domain.Brand;
import com.geekaca.ssm.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/all")
    public List<Brand> getAll() {
        List<Brand> brandList = brandService.getAll();
        return brandList;
    }
}
