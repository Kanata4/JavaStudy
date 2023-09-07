package com.geekaca.service;

import com.geekaca.domain.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestService {
    //自动装配
    @Autowired
    private BrandService brandService;

//    @Test
//    public void testGetAll(){
//        List<Brand> all = brandService.getAll();
//        Assert.assertNotNull(all);
//        Assert.assertTrue(all.size() > 0);
//        System.out.println(all);
//    }

    @Test
    public void testGetById(){
        Brand brand = brandService.getById(2);
        System.out.println(brand);
    }

    @Test
    public void testGetByBrandName() {
        Brand brand = new Brand();
        brand.setBrandName("B");
        List<Brand> brands = brandService.getByBrandName(brand);
        System.out.println(brands);
    }
}
