package com.geekaca.d06.homework;

import java.util.TreeMap;

public class Test02 {
    public static void main(String[] args) {
        TreeMap<Character,Integer> treemap = new TreeMap<>();
        String str = "aababcabcdabcde";
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
//            System.out.println(temp);
            boolean isContain = treemap.containsKey(temp);
            if (isContain == false) {
                System.out.println(temp + "第一次出现");
                treemap.put(temp,i);
            } else {
                System.out.println(temp + "不是第一次出现");
            }
        }

    }
}
