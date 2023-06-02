package com.geekaca.d5;

public class isSame {
    public static void main(String[] args) {
        int[] arr1 = {11, 22, 33, 44};
        int[] arr2 = {11, 22, 33, 44};
        System.out.println(isSameArr2(arr1, arr2));
    }

    public static boolean isSame(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            return false;
        } else if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static boolean isSameArr2(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            System.out.println("不允许为null");
            return false;
        }
        //找茬式 拦截方式
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
