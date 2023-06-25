package com.geekaca.test;

/**
 * 微信扫码登录
 */
public class UserServiceSaoma extends UserService{
    @Override
    public boolean checkLogin(String username, String password) {
        //调用微信的功能 实现登录
        return true;
    }
}
