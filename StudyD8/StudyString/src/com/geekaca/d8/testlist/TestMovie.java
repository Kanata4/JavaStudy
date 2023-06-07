package com.geekaca.d8.testlist;

import java.util.ArrayList;

public class TestMovie {
    public static void main(String[] args) {
        /**
         * 用集合存储 电影对象
         */
        ArrayList<Movie> movies = new ArrayList<>();
        Movie movie = new Movie();
        movie.setName("肖申克的救赎");
        movie.setScore(9.7);
        movie.setActor("罗宾斯");
        movies.add(movie);

        Movie movie2 = new Movie();
        movie2.setName("霸王别姬");
        movie2.setScore(9.5);
        movie2.setActor("张国荣");
        movies.add(movie2);

        Movie movie3 = new Movie();
        movie3.setName("肖申克的救赎2");
        movie3.setScore(9.7);
        movie3.setActor("罗宾斯2");
        movies.add(movie3);
        //调用Movie的构造器
        movies.add(new Movie("让子弹飞","姜文",9.7));

        /**
         * 集合中存放的是引用类型（钥匙号牌）
         */
//        System.out.println(movies);
        for (int i = 0; i < movies.size(); i++) {
            Movie movie1 = movies.get(i);
            System.out.println(movie1.getName() + " " + movie1.getActor() + " " + movie1.getScore() + "。");
        }
    }
}
