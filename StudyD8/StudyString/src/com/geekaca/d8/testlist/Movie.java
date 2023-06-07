package com.geekaca.d8.testlist;

public class Movie {
    //名字
    private String name;
    //主演
    private String actor;
    //评分 private 私有
    private double score;
    //想要自己加有参数构造器
    public Movie(String name, String actor, double score) {
        this.name = name;
        this.actor = actor;
        this.score = score;
    }

    public Movie() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    //自动生成toString

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", actor='" + actor + '\'' +
                ", score=" + score +
                '}';
    }
}
