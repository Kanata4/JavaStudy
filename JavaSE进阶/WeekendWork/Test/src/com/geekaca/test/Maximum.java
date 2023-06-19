package com.geekaca.test;

public class Maximum {
    public static void main(String[] args) {
        int[] arr = {34, 23, 56, 99, -2};
        int max = maxArray(arr);
        System.out.println(max);
    }

    public static int maxArray(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}
