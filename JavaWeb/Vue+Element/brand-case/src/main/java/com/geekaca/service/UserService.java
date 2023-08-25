package com.geekaca.service;

import com.geekaca.mapper.UserMapper;
import com.geekaca.pojo.User;
import com.geekaca.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

public class UserService {


    public User isLoginOk(String uname, String password) {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername(uname);
        user.setPassword(password);
        User user1 = userMapper.selectUserInfo(user);
        return user1;
    }
}
