package com.example.bibliotek.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

public class LoanDto {

        private Integer	loanId;

        private Integer	readerId;

        private Integer bookId;

        private LocalDate loanDate;

        private LocalDate returnDate;

    public LoanDto() {
    }

    public LoanDto(Integer loanId, Integer readerId, Integer bookId, LocalDate loanDate, LocalDate returnDate) {
        this.loanId = loanId;
        this.readerId = readerId;
        this.bookId = bookId;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LoanDto loanDto = (LoanDto) o;
        return loanId == loanDto.loanId && readerId == loanDto.readerId && bookId == loanDto.bookId && Objects.equals(loanDate, loanDto.loanDate) && Objects.equals(returnDate, loanDto.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanId, readerId, bookId, loanDate, returnDate);
    }

    @Override
    public String toString() {
        return "LoanDto{" +
                "loanId=" + loanId +
                ", readerId=" + readerId +
                ", bookId=" + bookId +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
