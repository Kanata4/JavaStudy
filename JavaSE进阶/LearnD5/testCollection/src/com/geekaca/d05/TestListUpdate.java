package com.geekaca.d05;

import java.util.ArrayList;
import java.util.Iterator;

public class TestListUpdate {
    public static void main(String[] args) {
        /**
         * 集合的遍历过程中的
         * 删除和修改
         */
        ArrayList<String> list = new ArrayList<>();
        list.add("极客咖");
        list.add("Java");
        list.add("Java");
        list.add("赵敏");
        list.add("赵敏");
        list.add("素素");
        System.out.println(list);

        Iterator<String> iterator = list.iterator();

        while(iterator.hasNext()){
            String nextValue = iterator.next();
            //把“Java”写前面为了避免 空指针异常
            if ("Java".equals(nextValue)){
//                list.remove("Java");//.ConcurrentModificationException  不允许在Iterator迭代过程中，list.remove删除元素
                iterator.remove();
            }
        }
        System.out.println(list);

        // foreach 遍历 ，删除
//        for(String item: list){
//            //ConcurrentModificationException foreach不允许遍历过程中删除元素
//            list.remove(item);
//        }
        //lambda 同样不能遍历的时候删除元素
//        list.forEach((item)->{
//            list.remove(item);
//        });

        for (int i = list.size() - 1; i >= 0 ; i--) {
            String item = list.get(i);
            if ("素素".equals(item)){
                list.remove(i);
            }
        }
        System.out.println(list);
    }
}
