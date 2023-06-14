package com.geekaca.j2.override_test;

public class Tiger extends Animal{
    public Tiger(String name) {
        //调用父类有参构造器
//        super(name);
        //默认自动调用 父类的无参构造器
        System.out.println("Tiger()无参构造器---");
    }

    /**
     * 当给父类加了有参数构造器后
     *
     * 子类报错原因：
     *
     * 子类默认也有一个无参数构造器
     * 子类无参构造器，会默认调用父类无参构造器
     */


    //覆盖  都是动物，都有跑这个行为
    // 跑的特点各不相同，  方法重写 来体现
    @Override
    public void run() {
        System.out.println(getName()+ "老虎跑---");
    }

}
