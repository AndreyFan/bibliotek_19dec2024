package com.example.bibliotek.entity;

import com.example.bibliotek.dto.BookDto;
import com.example.bibliotek.entity.enums.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Table(name= "books")
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "genre")
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @Column(name = "year_published")
    private int yearPublished;

    public Book() {
    }

    public Book(Integer bookId, String title, String authorName, Genre genre, int yearPublished) {
        this.bookId = bookId;
        this.title = title;
        this.authorName = authorName;
        this.genre = genre;
        this.yearPublished = yearPublished;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId && yearPublished == book.yearPublished && Objects.equals(title, book.title) && Objects.equals(authorName, book.authorName) && genre == book.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, authorName, genre, yearPublished);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", genre=" + genre +
                ", yearPublished=" + yearPublished +
                '}';
    }
}
