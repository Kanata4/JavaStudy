package com.geekaca.stu.controller;

import com.geekaca.stu.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adminInfo")
public class AdminInfoController {

    @Autowired
    private AdminInfoService adminInfoService;
}
