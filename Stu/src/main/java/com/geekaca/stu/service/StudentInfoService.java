package com.geekaca.stu.service;

import com.geekaca.stu.dao.StudentInfoDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class StudentInfoService {

    //Service 调用 Dao层
    @Resource
    private StudentInfoDao studentInfoDao;

}
