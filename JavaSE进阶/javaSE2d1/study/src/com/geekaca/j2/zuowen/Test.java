package com.geekaca.j2.zuowen;

public class Test {
    public static void main(String[] args) {
        StudentMiddle studentMiddle  =new StudentMiddle();
        studentMiddle.setTitle("我的爸爸");
        studentMiddle.setEnd("中学很开心");
        studentMiddle.showWord();
        System.out.println("==================");
        StudentChild studentChild = new StudentChild();
        studentChild.setTitle("我的爸爸");
        studentChild.setEnd("小学很开心");
        studentChild.showWord();

    }
}
