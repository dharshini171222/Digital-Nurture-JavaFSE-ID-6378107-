package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    private String libraryName;

    // Constructor for constructor injection
    public BookService(String libraryName) {
        this.libraryName = libraryName;
    }

    // Setter for setter injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String bookName) {
        System.out.println("[" + libraryName + "] Adding book: " + bookName);
        bookRepository.saveBook(bookName);
    }
}
