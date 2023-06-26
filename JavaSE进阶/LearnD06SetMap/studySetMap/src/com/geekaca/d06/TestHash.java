package com.geekaca.d06;

import java.util.HashSet;
import java.util.Set;

public class TestHash {
    public static void main(String[] args) {
        /**
         * Hash
         */
        String str = "Hello";
        System.out.println(str.hashCode());
        System.out.println("Java".hashCode());
        System.out.println("Hello".hashCode());

        Set<String> setStrs = new HashSet<>();
        setStrs.add("Hello");
        setStrs.add("Hello");
        System.out.println(setStrs);


    }
}
