package com.geekaca.d06;

import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {
    public static void main(String[] args) {
        /**
         * TreeMap特性
         */
        Map<Integer, String> myMap = new TreeMap<>();
        myMap.put(19,"Java");
        myMap.put(123,"Java");
        myMap.put(1429,"Java");
        myMap.put(159,"Java");
        myMap.put(119,"Java");
        System.out.println(myMap);
    }
}
