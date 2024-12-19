package com.example.bibliotek.service;

import com.example.bibliotek.dto.BookDto;
import com.example.bibliotek.entity.Book;

import java.util.List;

public interface BookService {

    boolean createBook(BookDto newBookDto) ;

    Book getBookById(Integer id) ;
    List<Book> getAllBooks();

    Book getBookByTitle(String title);

    boolean updateBook(BookDto upBookDto);

    void deleteBookById(Integer id);

}
