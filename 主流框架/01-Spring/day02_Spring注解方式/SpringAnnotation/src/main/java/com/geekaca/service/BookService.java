package com.geekaca.service;

import com.geekaca.domain.Book;

import java.util.List;

public interface BookService {
    public int show();

    public List<Book> getAll();

    public int delete();

    public int update();
}
