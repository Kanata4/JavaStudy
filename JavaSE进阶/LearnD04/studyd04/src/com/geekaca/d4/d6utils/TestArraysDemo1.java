package com.geekaca.d4.d6utils;

import java.util.Arrays;

public class TestArraysDemo1 {
    public static void main(String[] args) {
        int[] arr = {10,2,33,45,31,100};
        System.out.println(arr);

        String str = Arrays.toString(arr);
        System.out.println(str);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("--------二分查找--------");
        //先排序
        int index = Arrays.binarySearch(arr,50);
        System.out.println("50的index " + index);
    }
}
