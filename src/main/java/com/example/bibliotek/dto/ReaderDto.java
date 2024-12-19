package com.example.bibliotek.dto;


import java.time.LocalDate;
import java.util.Objects;

public class ReaderDto {

    private Integer readerId;

    private String readerName;

    private String readerPhone;

    private LocalDate registrationDate;

    private String email;

    public ReaderDto() {
    }

    public ReaderDto(Integer readerId, String readerName, String readerPhone, LocalDate registrationDate, String email) {
        this.readerId = readerId;
        this.readerName = readerName;
        this.readerPhone = readerPhone;
        this.registrationDate = registrationDate;
        this.email = email;
    }


    public Integer getReaderId() {
        return readerId;
    }

    public String getReaderName() {
        return readerName;
    }

    public String getReaderPhone() {
        return readerPhone;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public void setReaderPhone(String readerPhone) {
        this.readerPhone = readerPhone;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ReaderDto readerDto = (ReaderDto) o;
        return readerId == readerDto.readerId && Objects.equals(readerName, readerDto.readerName) && Objects.equals(readerPhone, readerDto.readerPhone) && Objects.equals(registrationDate, readerDto.registrationDate) && Objects.equals(email, readerDto.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(readerId, readerName, readerPhone, registrationDate, email);
    }

    @Override
    public String toString() {
        return "ReaderDto{" +
                "readerId=" + readerId +
                ", readerName='" + readerName + '\'' +
                ", readerPhone='" + readerPhone + '\'' +
                ", registrationDate=" + registrationDate +
                ", email='" + email + '\'' +
                '}';
    }
}
