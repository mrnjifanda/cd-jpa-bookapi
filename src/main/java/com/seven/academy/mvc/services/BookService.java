package com.seven.academy.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.seven.academy.mvc.models.Book;
import com.seven.academy.mvc.repositories.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    public Iterable<Book> allBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(Book newBook) {
        return bookRepository.save(newBook);
    }

    public Book findBook(Long idBook) {

        Optional<Book> optionalBook = bookRepository.findById(idBook);

        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {

            return null;
        }
    }
}
