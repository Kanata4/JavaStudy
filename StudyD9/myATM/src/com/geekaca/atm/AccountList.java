package com.geekaca.atm;

import java.util.ArrayList;

public class AccountList {

    //创建对象
    private static AccountList instance = new AccountList();

    //构造函数为private
    private AccountList(){}

    //获取唯一可用的对象
    public static AccountList getInstance(){
        return instance;
    }

    public void initAccounts(ArrayList<Account> accountList) {
        Account account = new Account();
        account.setUserName("zhangsan");
        account.setPassWord("abc123");
        account.setCardId("ICBC987654321");
        account.setMoney(30000);
        account.setQuotaMoney(4000);
        accountList.add(account);

        Account account2 = new Account();
        account2.setUserName("zhangwei");
        account2.setPassWord("abc123");
        account2.setCardId("54321");
        account2.setMoney(1000);
        account2.setQuotaMoney(4000);
        accountList.add(account2);

        Account account3 = new Account();
        account3.setUserName("qiudaoyu");
        account3.setPassWord("abc123");
        account3.setCardId("98765");
        account3.setMoney(1000);
        account3.setQuotaMoney(4000);
        accountList.add(account3);
    }
}
