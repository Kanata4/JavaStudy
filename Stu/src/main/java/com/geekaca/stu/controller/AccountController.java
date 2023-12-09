package com.geekaca.stu.controller;

import com.geekaca.stu.common.Result;
import com.geekaca.stu.domain.Account;
import com.geekaca.stu.service.impl.AdminInfoService;
import com.geekaca.stu.service.impl.AdminInfoServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;


@RestController
@RequestMapping
public class AccountController {

    @Autowired
    private AdminInfoService adminInfoService;

    @PostMapping("/login")
    //请求体 不止一个参数
    public Result login(@RequestBody Account user, HttpServletRequest request) {

        //校验
        if (ObjectUtils.isEmpty(user.getName()) ||
                ObjectUtils.isEmpty(user.getPassword()) || ObjectUtils.isEmpty(user.getLevel())){
            return Result.error("-1","请完善信息");
        }

        Integer level = user.getLevel();
        Account loginUser = new Account();
        if (1 == level) {
            // 管理员登录
            loginUser = adminInfoService.login(user.getName(),user.getPassword());
        }
        if (2 == level) {
            // 教师登录
        }
        if (3 == level) {
            // 学生登录
        }

        // 在session存用户信息
        request.getSession().setAttribute("user",loginUser);

        return Result.success(loginUser);
    }
}
