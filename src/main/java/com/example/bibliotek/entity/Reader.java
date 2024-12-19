package com.example.bibliotek.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Table(name = "readers")
@Entity
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reader_id")
    private Integer readerId;

    @Column(name = "reader_name")
    private String readerName;

    @Column(name = "reader_phone")
    private String readerPhone;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "email")
    private String email;

    public Reader() {
    }

    public Reader(Integer readerId, String readerName, String readerPhone, LocalDate registrationDate, String email) {
        this.readerId = readerId;
        this.readerName = readerName;
        this.readerPhone = readerPhone;
        this.registrationDate = registrationDate;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return readerId == reader.readerId && Objects.equals(readerName, reader.readerName) && Objects.equals(readerPhone, reader.readerPhone) && Objects.equals(registrationDate, reader.registrationDate) && Objects.equals(email, reader.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(readerId, readerName, readerPhone, registrationDate, email);
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readerId=" + readerId +
                ", readerName='" + readerName + '\'' +
                ", readerPhone='" + readerPhone + '\'' +
                ", registrationDate=" + registrationDate +
                ", email='" + email + '\'' +
                '}';
    }
}
