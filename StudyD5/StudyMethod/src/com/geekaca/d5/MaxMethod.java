package com.geekaca.d5;

public class MaxMethod {
    public static void main(String[] args) {
        int[] arr = {3,4,22,12,15,1};
        int max =findMax(arr);
        System.out.println(max);
        //ctrl + 鼠标左键 跳转定义
        showInfo("tom",23);
    }

    /**
     * 找最大值
     * input最大值 int[]
     * output输出 int
     * java的方法不支持返回多个值
     */
    public static int findMax(int[] arr){
        int max = arr[0];
        int indexOfMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
                indexOfMax = i;
            }
        }
        System.out.println(max);
        System.out.println("最大值的索引" + indexOfMax);
        return max;
    }

    public static void showInfo(String name,int age){
        System.out.println(" name: " + name + " age: " + age);
    }
}
