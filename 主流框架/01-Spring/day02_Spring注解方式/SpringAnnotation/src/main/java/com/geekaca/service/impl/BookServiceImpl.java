package com.geekaca.service.impl;

import com.geekaca.dao.BookMapper;
import com.geekaca.domain.Book;
import com.geekaca.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

//@Component("bookService")
@Service("bookService")
@Scope("singleton")
public class BookServiceImpl implements BookService {
    //声明依赖
    @Autowired
//    明确的指定 要依赖哪个bean
//    @Qualifier("bookDao")
    private BookMapper bookMapper;

    @Autowired
    private DataSource dataSource;


//    public void setBookMapper(BookMapper bookMapper) {
//        this.bookMapper = bookMapper;
//    }

    @Override
    public int show() {
//        try(Connection connection = dataSource.getConnection();){
//            System.out.println(connection.getMetaData().getDatabaseProductName());
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        System.out.println(" BookServiceImpl show");
//        bookMapper.test();
        Book book = new Book();
        book.setName("大明王朝");
        book.setDescription("明朝那些事");
        book.setType("历史");
        int saved = bookMapper.save(book);
        return saved;
    }

    @Override
    public List<Book> getAll() {
        return bookMapper.selectAll();
    }

    @Override
    public int delete() {
        int bookId = 2;
        int deleted = bookMapper.delete(bookId);
        return deleted;
    }

    @Override
    public int update() {
        int bookId = 3;
        Book book = new Book();
        book.setId(bookId);
        book.setName("大明王朝2");
        book.setDescription("明朝那些事2");
        book.setType("历史2");
        int updated = bookMapper.update(book);
        return updated;
    }

}
    //在构造器执行之后 执行此方法
//    @PostConstruct
//    public void doInit2(){
//        System.out.println("doInit333333");
//    }
//    //在对象被销毁之前 此方法被调用
//    @PreDestroy
//    public void myDestroy(){
//        System.out.println("myDestory");
//    }

