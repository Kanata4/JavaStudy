package com.geekaca.d09;

public class TestRecursionDemo1 {
    public static void main(String[] args) {
        System.out.println();
        hello();
    }

    private static void hello() {
        System.out.println("hello");
        test();
    }

    private static void test() {
        System.out.println("test");
        hello();
    }
}
