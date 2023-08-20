package com.geekaca.web.mapper;

import com.geekaca.web.pojo.User;

public interface UserMapper {
    int selectUser(User user);

    int addUser(User user);
}
