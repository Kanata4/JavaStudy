package com.geekaca.atm;

import java.util.ArrayList;

/**
 * 枚举方式实现单例
 */
public enum AccountSys {
    //枚举内成员变量，默认是常量 public static final
    ACC_INSTANCE;
    //枚举的成员变量
    ArrayList<Account> accounts = new ArrayList<>();
}
