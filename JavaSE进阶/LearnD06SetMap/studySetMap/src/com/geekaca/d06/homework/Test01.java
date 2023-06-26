package com.geekaca.d06.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test01 {
    public static void main(String[] args) {
        long starTime1 = System.currentTimeMillis();
        Map<String,String> studentMap1 = new HashMap<String,String>();
        for (int i = 0; i < 100000; i++) {
            studentMap1.put("Tom" + i,"学生" + i);
        }
        System.out.println(studentMap1.get("Tom89898"));
        long endTime1 = System.currentTimeMillis();
        System.out.println("耗时" + (endTime1 - starTime1 + "ms"));

        long starTime2 = System.currentTimeMillis();
        List<String> studentList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            studentList.add("Tom" + i);
        }
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).equals("Tom89898")){
                System.out.println(studentList.get(i));
                break;
            }
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("耗时" + (endTime2 - starTime2 + "ms"));
    }
}
