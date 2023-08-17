package com.geekaca.jsp.mapper;

import com.geekaca.jsp.pojo.User;

public interface UserMapper {

    int selectUser(User user);

    int addUser(User user);
}
