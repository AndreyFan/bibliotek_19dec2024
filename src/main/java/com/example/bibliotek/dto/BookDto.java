package com.example.bibliotek.dto;

import com.example.bibliotek.entity.enums.Genre;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

        private Integer bookId;

        private String title;

        private String authorName;

        private String  genre;

        private int yearPublished;

}
