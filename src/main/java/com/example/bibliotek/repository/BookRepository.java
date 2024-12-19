package com.example.bibliotek.repository;


import com.example.bibliotek.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "select * from books ce where ce.title=?1", nativeQuery = true)
    Optional<Book> getBookByTitle(String title);

}