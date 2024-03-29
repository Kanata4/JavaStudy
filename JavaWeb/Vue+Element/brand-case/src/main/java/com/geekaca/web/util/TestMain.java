package com.geekaca.web.util;

import com.alibaba.fastjson.JSON;
import com.geekaca.web.pojo.Brand;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        /**
         * 测试  JSON
         */
        List<Brand> list = new ArrayList();
        for (int i = 0; i < 5; i++) {
            Brand brand = new Brand();
            brand.setId(i);
            brand.setBrandName("比亚迪");
            brand.setCompanyName("深圳比亚迪");
            brand.setOrdered(100);
            brand.setDescription("混动汽车");
            brand.setStatus(1);
            brand.setTypeId(1);
            list.add(brand);
        }
        //把List 转换为JSON 字符串
        String s = JSON.toJSONString(list);
        System.out.println(s);
    }
}
