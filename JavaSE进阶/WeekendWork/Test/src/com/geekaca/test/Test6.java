package com.geekaca.test;

import java.util.Arrays;

public class Test6 {
    public static void main(String[] args) {
        test();
    }
    public static void test() {
        double[] scores = {23, 4, 45, 90, 54, 6, 88.9};
        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] > scores[i + 1]) {
                swapValue(scores, i, i + 1);
            }
        }
        System.out.println(Arrays.toString(scores));
    }

    /**
     * 交换两个元素的值
     * @param arr
     * @param i
     * @param j
     */
    public static void swapValue(double[] arr, int i, int j) {
        double tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
