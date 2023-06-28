package com.geekaca.review628;

import java.util.*;

public class TestStudent {
    public static void main(String[] args) {
        /**
         * Map{Key:学号 value:Student对象}
         *
         * ATM
         *
         * 所有账户信息 List<Account>
         *
         * Map<卡号：Account>
         * 用卡号查找 账号 是一步到位
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学号");
        int id = sc.nextInt();
        Map<Integer,Student> studentMap = new HashMap<>();
        studentMap.put(01,new Student(01,"张维",'男',19,"一班"));
        studentMap.put(02,new Student(02,"张维2",'女',29,"一班"));
        studentMap.put(03,new Student(03,"张维3",'男',39,"二班"));
        if (studentMap.containsKey(id)){
            System.out.println(studentMap.get(id) + "存在！");
        } else {
            System.out.println("不存在此学号");
            return;
        }
    }
}
