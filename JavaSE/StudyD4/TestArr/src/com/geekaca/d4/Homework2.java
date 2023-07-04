package com.geekaca.d4;

public class Homework2 {
    public static void main(String[] args) {
        int[] arr1 = {23,34,15,2,68};
        int max = arr1[0];
        int maxIndex = 0;
        for (int i = 0; i < 5; i++) {
            if(arr1[i] > max){
                max = arr1[i];
                maxIndex = i;
            }
        }
        System.out.println("数组的最大值为" + max + "，输出最大值的索引为" + maxIndex);
    }
}
