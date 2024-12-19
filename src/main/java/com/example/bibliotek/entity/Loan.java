package com.example.bibliotek.entity;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Table(name = "loans")
@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Integer	loanId;

    @Column(name = "reader_id")
    private Integer	readerId;

    @Column(name= "book_id")
    private Integer bookId;

    @Column(name = "loan_date")
    private LocalDate loanDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    public Loan() {
    }

    public Loan(Integer loanId, Integer readerId, Integer bookId, LocalDate loanDate, LocalDate returnDate) {
        this.loanId = loanId;
        this.readerId = readerId;
        this.bookId = bookId;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return loanId == loan.loanId && readerId == loan.readerId && bookId == loan.bookId && Objects.equals(loanDate, loan.loanDate) && Objects.equals(returnDate, loan.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanId, readerId, bookId, loanDate, returnDate);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", readerId=" + readerId +
                ", bookId=" + bookId +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
