package com.geekaca.review628;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        /**
         * 从命令行读入一个字符串 表示一个年份
         * 输出该年的世界杯冠军
         * 没举办 输出 没举办
         */
        Map<String,String> championMap = new HashMap<>();
        championMap.put("1930年", "乌拉圭");
        championMap.put("1934年", "意大利");
        championMap.put("1938年", "意大利");
        championMap.put("1950年", "乌拉圭");
        championMap.put("1954年", "西德");
        championMap.put("1958年", "巴西");
        championMap.put("1962年", "巴西");
        championMap.put("1966年", "英格兰");
        championMap.put("1970年", "巴西");
        championMap.put("1974年", "西德");
        championMap.put("1978年", "阿根廷");
        championMap.put("1982年", "意大利");
        championMap.put("1986年", "阿根廷");
        championMap.put("1990年", "西德");
        championMap.put("1994年", "巴西");
        championMap.put("1998年", "法国");
        championMap.put("2002年", "巴西");
        championMap.put("2006年", "意大利");
        championMap.put("2010年", "西班牙");
        championMap.put("2014年", "德国");

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份：");
        String inputYear = sc.next();

        if (!championMap.containsKey(inputYear)){
            System.out.println("没举办世界杯！");
        } else {
            System.out.println("该年的世界杯冠军是" + championMap.get(inputYear));
        }
    }
}
