package com.geekaca.web.service;

import com.geekaca.web.mapper.UserMapper;
import com.geekaca.web.pojo.User;
import com.geekaca.web.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

public class UserService {

    public boolean isLoginOk(String username,String password){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        int i = userMapper.selectUser(user);
        sqlSession.close();
        return i > 0;
    }

    public int addUser(String uname,String password){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername(uname);
        user.setPassword(password);
        int i = userMapper.addUser(user);
        return i;
    }
}
