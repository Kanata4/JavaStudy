package com.geekaca.stu.service;


import com.geekaca.stu.domain.Account;
import com.geekaca.stu.domain.AdminInfo;
import com.geekaca.stu.mapper.AdminInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class AdminInfoService {

    @Autowired
    private AdminInfoMapper adminInfoMapper;


    public Account login(String name, String password) {

        // 通过用户名和密码在数据库查记录
        AdminInfo adminInfo = adminInfoMapper.findByNameAndPassword(name, password);

        if (ObjectUtils.isEmpty(adminInfo)) {
            throw new RuntimeException("用户名或密码错误");
        }

        return null;
    }
}
