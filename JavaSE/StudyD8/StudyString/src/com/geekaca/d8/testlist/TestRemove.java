package com.geekaca.d8.testlist;

import java.util.ArrayList;

public class TestRemove {
    public static void main(String[] args) {
        /**
         * int的包装类 Integer 引用类型
         */
        ArrayList<Integer> scoreList = new ArrayList<>();
        scoreList.add(98);
        scoreList.add(77);
        scoreList.add(66);
        scoreList.add(89);
        scoreList.add(79);
        scoreList.add(50);
        scoreList.add(100);
        for (int i = 0; i < scoreList.size() - 1; i++) {
            System.out.println(scoreList.get(i) + " ");
        }
        for (int i = scoreList.size() - 1; i >= 0; i--) {
            Integer curScore = scoreList.get(i);
            if (curScore < 80) {
                //从集合中删除
                /**
                 * 每次删除元素后
                 * 集合会重新排序
                 */
                Integer removed = scoreList.remove(i);
                System.out.println("删除了" + removed);
            }
        }
        System.out.println(scoreList);
    }
}
