package com.geekaca.d5.d5homework;

import java.util.Random;
import java.util.Scanner;

public class ArrayRandomSum {
    public static void main(String[] args) {

        System.out.println(showSum(9));
    }

    //根据传入的数字 来动态的定义数组长度
    public static int showSum(int number){
        int[] arr = new int[number];
        int sum = 0;
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            arr[i] = random.nextInt(100);
            System.out.println(arr[i]);
            sum += arr[i];
        }
        return sum;
    }
}
