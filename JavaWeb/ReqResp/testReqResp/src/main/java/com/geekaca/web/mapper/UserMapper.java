package com.geekaca.web.mapper;

import com.geekaca.web.pojo.User;

public interface UserMapper {
    int selectByUnamePass(User user);

    void add(User user);
}
