package com.geekaca.jsp.service;

import com.geekaca.jsp.mapper.UserMapper;
import com.geekaca.jsp.pojo.User;
import com.geekaca.jsp.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

public class UserService {

    public boolean isLoginOk(String uname,String password){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername(uname);
        user.setPassword(password);
        int i = userMapper.selectUser(user);
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
