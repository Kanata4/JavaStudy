package com.geekaca.test;

public class UserServiceFacebook extends UserService{
    @Override
    public boolean checkLogin(String username, String password) {
        //连接facebook的 功能 实现用户名 密码 的校验
        return true;
    }
}
