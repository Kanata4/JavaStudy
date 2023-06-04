package com.geekaca.d5.testoverload;

public class TestReturn {
    public static void main(String[] args) {
        testContinue();
    }

    public static void testBreak(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                if(j==3) {
                    break;
                }
                System.out.print("#");
            }
            System.out.println(" ");
        }
    }

    public static void testContinue(){
        for (int i = 1; i <= 30; i++) {
            if (i == 10 || i == 11) {
                System.out.println(i + "号老婆打扫卫生");
                continue;
            }
            System.out.println(i + "号你打扫卫生");
        }
    }
}
