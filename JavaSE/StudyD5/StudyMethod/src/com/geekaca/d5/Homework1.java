package com.geekaca.d5;

import java.util.Random;

public class Homework1 {
    public static void main(String[] args) {
        int[] array = new int[6];
        arrayResult(array);
    }

    public static void arrayResult (int[] arrs){
        Random random = new Random();
        for (int i = 0;i<arrs.length;i++){
            arrs[i] = random.nextInt(101);
        }
        String str = "[";
        int sum = 0;
        for (int i = 0; i < arrs.length; i++) {
            sum += arrs[i];
            if (arrs.length - 1 == i){
                str += arrs[i];
            }else{
                str += arrs[i] + ",";
            }
        }
        str += "]";
        System.out.println(str);
        System.out.println("所有元素的总和为" + sum);
    }

}
