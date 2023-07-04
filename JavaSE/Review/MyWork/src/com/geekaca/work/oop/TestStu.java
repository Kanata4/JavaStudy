package com.geekaca.work.oop;

public class TestStu {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "小明";
        s1.sex = '男';
        s1.hobby = "玩游戏，睡觉，听歌";
        s1.study();
        s1 = null;
        /**
         * 当没有引用变量指向 堆中的 那个 Student对象后
         * 他就会被变成垃圾 Java的回收机制 GC 会定期检查 回收掉空间
         * 相比较C++ 需要开发者自己来管理内存（很容易出错）
         * 清理机制：有算法，根据不同的业务场景，优化方案（进阶）
         */

        //把学生类型的s1变量赋值给学生类型的s2变量
        //s2对象 指向 s1  两个引用类型的变量指向同一个对象
        /**
         * s1 钥匙号牌 19 号柜子
         * s2 一个新的钥匙号牌 上面刻的号码也是19 指向19号柜子
         *
         * 修改对象，两个引用变量都受到影响
         */
//        Student s2 = s1;
//        s2.hobby = "爱提问";
//        s2.study();

        Student stuConstru = new Student("Tom",'男',"跑步");
        stuConstru.study();
    }
}
