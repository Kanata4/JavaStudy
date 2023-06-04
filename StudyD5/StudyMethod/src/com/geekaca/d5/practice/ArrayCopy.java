package com.geekaca.d5.practice;

import java.util.Arrays;

public class ArrayCopy {
    public static void main(String[] args) {
        int[] arr1 = {11,22,33,44,55};
        copyArray(arr1);
    }

    public static void copyArray(int[] arr){
        int newArr[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        System.out.println("旧数组为" + Arrays.toString(arr));
        System.out.println("新数组为" + Arrays.toString(newArr));
    }
}
