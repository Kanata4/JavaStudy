package com.geekaca.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
public class BrandController {
    @RequestMapping("/{id}")
    public String getById(@PathVariable Integer id){
        System.out.println("id ==>" + id);
        return "hello, spring boot!";
    }

}