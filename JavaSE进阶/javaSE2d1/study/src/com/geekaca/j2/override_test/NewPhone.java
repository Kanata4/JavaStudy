package com.geekaca.j2.override_test;

public class NewPhone extends Phone{
    //方法重写 override
    //读at 注解 annotation java编译器语法检查的方式
    @Override
    public void call() {
        //super指向父类
        super.call();
        /**
         * 既具备了父类
         * 又具备了新功能
         */
        System.out.println("还可以发送语音电话");
    }

    @Override
    public void sendMsg() {
        super.sendMsg();
    }
}
