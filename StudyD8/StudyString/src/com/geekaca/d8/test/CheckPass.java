package com.geekaca.d8.test;

import java.util.Scanner;

public class CheckPass {
    public static void main(String[] args) {
        //存在用户名和密码
        String name = "hello";
        String pwd = "123456";
        // 给三次机会
        for (int i = 0; i < 3; i++) {
            Scanner sc = new Scanner(System.in);
            //创建键盘录入对象
            System.out.println("请输入用户名");

            String username = sc.next();
            System.out.println("请输入用户密码");
            String password = sc.next();

            if (name.equals(username) && pwd.equals(password)) {
                System.out.println("登陆成功");
                break;
            } else {
                if ((2 - i) == 0) {
                    System.out.println("终止");
                } else {
                    System.out.println("登录失败，你还剩" + (2 - i) + "机会");
                }
            }
        }
    }
}
