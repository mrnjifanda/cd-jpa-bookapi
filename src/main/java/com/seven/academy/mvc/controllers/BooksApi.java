package com.seven.academy.mvc.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seven.academy.mvc.models.Book;
import com.seven.academy.mvc.models.User;
import com.seven.academy.mvc.services.BookService;
import com.seven.academy.mvc.services.UserService;

@RestController
public class BooksApi {

    private final BookService bookService;

    public BooksApi(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/api/books")
    public Iterable<Book> index() {
    
       return this.bookService.allBooks();
    }
    
    @PostMapping("/api/books")
    public Book create(
        @RequestParam(value="title") String title,
        @RequestParam(value="description") String desc,
        @RequestParam(value="language") String lang,
        @RequestParam(value="pages") Integer numOfPages
    ) {

        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {

        return bookService.findBook(id);
    }
}
