package com.geekaca.test;

import java.util.Random;

public class Test4 {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randInt = 79 + random.nextInt(100 - 79 + 1);
            System.out.println(randInt);
        }

    }
}
