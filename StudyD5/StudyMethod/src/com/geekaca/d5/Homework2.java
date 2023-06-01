package com.geekaca.d5;

public class Homework2 {
    public static void main(String[] args) {
        int[] array = {72,89,65,87,91,82,71,93,76,68};
        System.out.println(count(array));
    }

    public static double count (int[] arrs){
        int sum = 0;
        for (int i = 0; i < arrs.length; i++) {
            sum += arrs[i];
        }
        double averageArray = sum * 1.0 / arrs.length;
        return averageArray;
    }
}
