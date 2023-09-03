package com.geekaca.ssm.controller;

import com.geekaca.ssm.domain.Brand;
import com.geekaca.ssm.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//注解 控制器类
@RestController
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @RequestMapping("/save")
    public int save(@RequestBody Brand brand) {
        return brandService.save(brand);
    }

    @RequestMapping("/update")
    public int update(@RequestBody Brand brand) {
        return brandService.update(brand);
    }

    @RequestMapping("/delete/{id}")
    public int delete(@PathVariable("id") Integer id) {
        return brandService.delete(id);
    }

    @RequestMapping("/get/{id}")
    public Brand getById(@PathVariable("id") Integer id) {
        return brandService.getById(id);
    }

    @RequestMapping("/all")
    public List<Brand> getAll() {
        return brandService.getAll();
    }

    @RequestMapping("/getByName")
    public List<Brand> getByBrandName(@RequestBody Brand brand) {
        return brandService.getByBrandName(brand);
    }
}
