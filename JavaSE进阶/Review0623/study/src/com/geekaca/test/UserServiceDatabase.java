package com.geekaca.test;

public class UserServiceDatabase extends UserService{
    @Override
    public boolean checkLogin(String username, String password) {
        //从数据库中搜索 验证用户名和密码 是否正确
        return true;
    }
}
