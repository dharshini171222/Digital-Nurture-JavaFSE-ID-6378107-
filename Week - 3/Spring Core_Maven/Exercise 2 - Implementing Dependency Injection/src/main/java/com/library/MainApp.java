package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Spring injects BookRepository into BookService automatically
        BookService bookService = (BookService) context.getBean("bookService");

        bookService.addBook("1984 by George Orwell");
    }
}
