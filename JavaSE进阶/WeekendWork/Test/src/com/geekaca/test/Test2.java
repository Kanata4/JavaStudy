package com.geekaca.test;

import java.util.Arrays;

public class Test2 {
    /**
     * 输入 int[] arr
     * 返回 Boolean
     */
    public static void main(String[] args) {
        int[] arr1 = {10,12,1,2,12};
        int[] arr2 = {10,12,1,2,13};
        boolean isChongfu = checkWeiyi(arr1);
        boolean isChongfu2 = checkWeiyi(arr2);
        System.out.println(Arrays.toString(arr1) + isChongfu);
        System.out.println(Arrays.toString(arr2) + isChongfu2);
    }

    public static boolean checkWeiyi(int[] arr) {
        if (arr == null) {
            return false;
        }
        if (arr.length == 0 || arr.length == 1) {
            return false;
        }

        for (int j = 0; j < arr.length; j++) {
            int current = arr[j];
            for (int i = j + 1; i < arr.length; i++) {
                if (current == arr[i]) {
                    //找到了和当前元素值相等的元素
                    return true;
                }
            }
        }
        return false;
    }
}
