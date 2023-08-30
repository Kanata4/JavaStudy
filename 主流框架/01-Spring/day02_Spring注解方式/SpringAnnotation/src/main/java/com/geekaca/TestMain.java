package com.geekaca;

import com.geekaca.config.MySpringConfig;
import com.geekaca.domain.Book;
import com.geekaca.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        //获取一个注解方式声明的IOC容器
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MySpringConfig.class);
        BookService bookService = (BookService) ctx.getBean("bookService");
//        int show = bookService.show();
//        System.out.println(show);
//        List<Book> all = bookService.getAll();
//        all.forEach(book -> {
//            System.out.println(book.toString());
//        });
//        List<Book> all1 = bookService.getAll();
//        all1.forEach(book -> {
//            String bookName = book.getName();
//            System.out.println(bookName);
//        });

//        int deleted = bookService.delete();
//        System.out.println(deleted);

        int updated = bookService.update();
        System.out.println(updated);
    }
}
