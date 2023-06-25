package com.geekaca.d05.homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Test02 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            arrayList.add("Tom" + i);
        }
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            linkedList.add("Tom" + i);
        }

        Random r = new Random(100000);
        for (int i = 0; i < 100; i++) {
            arrayList.remove(r);
        }
        for (int i = 0; i < 100; i++) {
            linkedList.remove(r);
        }

        long starTime1 = System.currentTimeMillis();
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            String item = arrayList.get(i);
            if ("Tom99".equals(item)) {
                System.out.println("找到了");
                break;
            }
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println(endTime1 - starTime1 + "ms");

        long starTime2 = System.currentTimeMillis();
        for (int i = linkedList.size() - 1; i >= 0; i--) {
            String item = linkedList.get(i);
            if ("Tom99".equals(item)) {
                System.out.println("找到了");
                break;
            }
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println(endTime2 - starTime2 + "ms");
    }
}
