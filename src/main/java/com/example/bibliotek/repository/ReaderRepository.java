package com.example.bibliotek.repository;

import com.example.bibliotek.dto.ReaderDto;
import com.example.bibliotek.entity.Book;
import com.example.bibliotek.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ReaderRepository extends JpaRepository<Reader, Integer> {

    @Query(value = "select * from readers ce where ce.reader_phone=?1", nativeQuery = true)
    Optional<Reader> getReaderByPhone(String phone);

}
