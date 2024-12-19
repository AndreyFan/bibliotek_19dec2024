package com.example.bibliotek.controller;


import com.example.bibliotek.dto.BookDto;
import com.example.bibliotek.entity.Book;
import com.example.bibliotek.entity.enums.Genre;
import com.example.bibliotek.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;


import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private BookService bookServiceMock;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getBookById() throws Exception {

        Integer bookId = 1;
        Book mockBook = new Book(bookId, "To Kill a Mockingbird", "Harper Lee", Genre.FICTION, 1960);
        when(bookServiceMock.getBookById(bookId)).thenReturn(mockBook);
        this.mockMvc.perform(get("/book/find/{id}", bookId))
                .andDo(print()) //печать лога вызова
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookId").exists())
                .andExpect(jsonPath("$.bookId").value(1))
                .andExpect(jsonPath("$.title").value("To Kill a Mockingbird"))
                .andExpect(jsonPath("$.authorName").value("Harper Lee"))
        ;
    }

    @Test
     void getAllBooks() throws Exception {
        when(bookServiceMock.getAllBooks()).thenReturn(List.of(new Book(1,"To Kill a Mockingbird", "Harper Lee", Genre.FICTION, 1960)));
        this.mockMvc.perform(get("/book"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$..bookId").value(1))
                .andExpect(jsonPath("$[0].title").value("To Kill a Mockingbird"))
                .andExpect(jsonPath("$[0].authorName").value("Harper Lee"))
                ;
    }

   @Test
    void createBook() throws Exception {
        when(bookServiceMock.createBook(any(BookDto.class))).thenReturn(true);
        this.mockMvc.perform(post("/book")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {
                            "bookId": null,
                            "title": "TestName",
                             "authorName": "TestAuthor",
                             "genre": null,
                              "yearPublished": 2024
                        }
                        """
                        ))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void updateBook() throws Exception {
        BookDto inputBook = new BookDto(1, "NewTestTitle", "NewTestAuthor", null, 2024);
        BookDto expectedBook = inputBook;

        when(bookServiceMock.updateBook(inputBook))
                .thenReturn(true);

        this.mockMvc.perform(put("/book")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputBook))) // jackson: object -> json
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void deleteBookById() throws Exception {

        Integer inputId = 1;

        this.mockMvc.perform(delete("/book/{id}", inputId))
                .andDo(print())
                .andExpect(status().isOk());

        //return void
        verify(bookServiceMock).deleteBookById(inputId);

    }



}