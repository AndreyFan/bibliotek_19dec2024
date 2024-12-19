package com.example.bibliotek.controller;

import com.example.bibliotek.dto.BookDto;
import com.example.bibliotek.entity.Book;
import com.example.bibliotek.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/find/{id}")
    public Book getBookById(@PathVariable(name = "id") Integer id) {
        return bookService.getBookById(id);
    }

    @GetMapping()
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(value = "/get")
    public Book getBookByTitle(@RequestParam("title") String title) {
        return bookService.getBookByTitle(title);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping //Jackson
    public boolean createBook(@RequestBody BookDto newBookDto) { //insert
        return bookService.createBook(newBookDto);
    }

    @PutMapping
    public boolean updateBook(@RequestBody BookDto upBookDto) {
        return bookService.updateBook(upBookDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBookById(@PathVariable Integer id) {
        bookService.deleteBookById(id);
    }
}
