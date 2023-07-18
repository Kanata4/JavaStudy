package com.geekaca.test.xml;

public class Book {
    private int id;
    private String desc;
    private String name;
    private String author;
    private String sale;

    public Book(int id, String desc, String name, String author, String sale) {
        this.id = id;
        this.desc = desc;
        this.name = name;
        this.author = author;
        this.sale = sale;
    }

    public Book() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", sale='" + sale + '\'' +
                '}';
    }
}

