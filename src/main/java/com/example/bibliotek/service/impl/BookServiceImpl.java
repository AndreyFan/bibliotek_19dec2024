package com.example.bibliotek.service.impl;

import com.example.bibliotek.dto.BookDto;
import com.example.bibliotek.entity.Book;
import com.example.bibliotek.entity.enums.Genre;
import com.example.bibliotek.exeption.BookDoesntExistException;
import com.example.bibliotek.exeption.error_messeges.ErrorMessage;
import com.example.bibliotek.repository.BookRepository;
import com.example.bibliotek.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    public final BookRepository bookRepository;

    @Override
    public Book getBookById(Integer id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (!optionalBook.isPresent()) {
            throw new BookDoesntExistException(ErrorMessage.BOOK_NOT_EXIST);
        }
        System.out.println("User: " + optionalBook.get());
        Book book = optionalBook.get();
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> all = bookRepository.findAll();
        return all;
    }

    @Override
    public Book getBookByTitle(String title) {
        Optional<Book> optionalBook = bookRepository.getBookByTitle(title);
        if (!optionalBook.isPresent()) {
            throw new BookDoesntExistException(ErrorMessage.BOOK_NOT_EXIST);
        }
        System.out.println("User: " + optionalBook.get());
        Book book = optionalBook.get();
        return book;
    }

    @Override
    public boolean createBook(BookDto newBookDto) {
        Book createBook = new Book(null, newBookDto.getTitle(), newBookDto.getAuthorName(), Genre.valueOf(newBookDto.getGenre().toUpperCase()), newBookDto.getYearPublished());
        Book newBook = bookRepository.save(createBook);
        return newBook.getBookId() != 0;
    }

    @Override
    public boolean updateBook(BookDto updatedBookDto) {
        Book upBook = new Book(updatedBookDto.getBookId(), updatedBookDto.getTitle(), updatedBookDto.getAuthorName(), null, updatedBookDto.getYearPublished());
        Book newUpBook = bookRepository.save(upBook);
        return newUpBook.getBookId() != 0;
    }

    @Override
    public void deleteBookById(Integer id) {
        Book deleteBook = bookRepository.findById(id).orElse(null);
        if (deleteBook == null) {
            throw new RuntimeException("Нету такого объекта с Id = " + id);
        }
       else bookRepository.delete(deleteBook);
    }

}
