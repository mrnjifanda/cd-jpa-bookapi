package com.seven.academy.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.seven.academy.mvc.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

    // List<Book> findAll();

    List<Book> findByDescriptionContaining(String search);

    Long countByTitleContaining(String search);

    Long deleteByTitleStartingWith(String search);
}
