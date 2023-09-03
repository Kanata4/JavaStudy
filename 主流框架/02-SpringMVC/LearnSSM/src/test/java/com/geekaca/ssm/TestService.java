package com.geekaca.ssm;

import com.geekaca.ssm.config.SpringConfig;
import com.geekaca.ssm.domain.Brand;
import com.geekaca.ssm.service.BrandService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//设置Spring环境对应的配置类, 测试service层的逻辑，不需要SpringMVC
@ContextConfiguration(classes = SpringConfig.class)
public class TestService {
    //自动装配
    @Autowired
    private BrandService brandService;

    @Test
    public void testGetAll(){
        List<Brand> all = brandService.getAll();
        Assert.assertNotNull(all);
        Assert.assertTrue(all.size() > 0);
        System.out.println(all);
    }

    @Test
    public void testGetById(){
        Brand brand = brandService.getById(1);
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
