package com.geekaca.d8.testlist;

import java.util.ArrayList;

public class HelloList {
    public static void main(String[] args) {
        String[] arr = new String[10];

        ArrayList arrayList = new ArrayList();
        arrayList.add("hello");
        arrayList.add(99);
        arrayList.add("测试");
        arrayList.add(1,"你好");
        System.out.println("size：" + arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        System.out.println(arrayList.get(0));
    }
}
