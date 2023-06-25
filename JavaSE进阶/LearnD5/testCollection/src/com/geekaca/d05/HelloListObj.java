package com.geekaca.d05;

import java.util.ArrayList;
import java.util.List;

public class HelloListObj {
    public static void main(String[] args) {
        /**
         * 集合中放对象
         * String Integer Java提供的数据类型
         * Movie 自己定义的类 ，自定义的类也是一种数据类型 都是数据类型
         */
        List<Movie> movieList = new ArrayList<>();
        Movie movie = new Movie("唐人街探案",8.5,"王宝强,刘昊然");
        movieList.add(movie);
        movieList.add(new Movie("《你好，》",9.5,"张"));
        movieList.add(new Movie("《刺杀小说家》",8.6,"杨幂"));

        //1 foreach
        for (Movie mv:movieList){
            System.out.println(mv);
        }
        System.out.println("============");
        //2 用Lambda方式遍历集合
        movieList.forEach((movie1) -> {
            System.out.println(movie1);
        });
    }
}
