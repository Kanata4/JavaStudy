package com.geekaca.d05.homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        List<String> studentList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            studentList.add("Tom" + i);
        }
        List<String> studentList2 = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            studentList2.add("Tom" + i);
        }

        for (int i = 0; i < studentList2.size(); i++) {
            Iterator<String> iterator = studentList.iterator();
            while (iterator.hasNext()){
                String temp = iterator.next();
                if (temp.equals(studentList2.get(i))){
                    iterator.remove();
                }
            }
        }
        System.out.println(studentList);
    }
}
