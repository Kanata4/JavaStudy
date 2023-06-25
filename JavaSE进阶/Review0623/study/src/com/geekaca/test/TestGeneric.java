package com.geekaca.test;

import java.util.ArrayList;

public class TestGeneric {
    public static void main(String[] args) {
        /**
         * 泛型
         * 集合
         * 集合可以放所有的引用类型
         * 所有引用类型 都有直接或者间接的超级父类java.lang.Obecjt
         */
        Animal animal = new Animal("小老虎");
        ArrayList list = new ArrayList();
        /**
         * 把元素放入集合 就是去了原本类型
         */
        list.add(animal);
        //拿出来都变成普通Object
//        Object object = list.get(0);
        Animal object = (Animal)list.get(0);

        //泛型机制
        ArrayList<Animal> list2 = new ArrayList<>();
//        list2.add("test");
        //放入时候会检查
        list2.add(animal);
        //取出时候 直接就是泛型声明的类型
        Animal animal1 = list2.get(0);
        System.out.println(animal1.getName());

    }
}