package com.geekaca.atm;

import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReviewMain {
    public static void main(String[] args) {
        //字符串分割
        String names = "张无忌,张三丰,刘德华,周芷若";
        String[] splitedArr = names.split(",");
        ArrayList<Account> accountList = new ArrayList<>();
        for (int i = 0; i < splitedArr.length; i++) {
            String sname = splitedArr[i];
            Account acc= new Account();
            acc.setUserName(sname);
            accountList.add(acc);
        }
        //搜索 找不到提示没有找到
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("请输入姓名：");
            String inputName = sc.next();
            boolean isFound = false;
            for (int i = 0; i < accountList.size(); i++) {
                Account account = accountList.get(i);
                String userName = account.getUserName();
                if (userName.contains(inputName)){
                    //只写account 默认写是调用toString方法
                    //系统自动提供，但是打印的是地址
                    System.out.println("找到了名字含有"+ inputName + "的同学" + account.toString());
                    isFound = true;
                }
            }
            if (!isFound) {
                System.out.println("没找到名字含有 " + inputName + "的学生");
            }
        }
    }
}
