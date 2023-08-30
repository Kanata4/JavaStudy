package com.geekaca.dao;

import com.geekaca.domain.Book;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {

    int save(Book book);

    List<Book> selectAll();

    int delete(int id);

    int update(Book book);
}
