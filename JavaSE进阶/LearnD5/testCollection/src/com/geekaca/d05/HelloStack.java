package com.geekaca.d05;

import java.util.Stack;

public class HelloStack {
    public static void main(String[] args) {
        /**
         * 栈结构的类
         */
        Stack<String> stack = new Stack();
        stack.push("tom");
        stack.push("jack");
        stack.push("Jerry");

        System.out.println(stack);
        //取栈顶元素，并且从栈中移除
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
