package com.example.bibliotek.service;

import com.example.bibliotek.dto.LoanDto;
import com.example.bibliotek.entity.Book;
import com.example.bibliotek.entity.Loan;
import com.example.bibliotek.exeption.BookDoesntExistException;
import com.example.bibliotek.exeption.LoanDoesntExistException;
import com.example.bibliotek.exeption.error_messeges.ErrorMessage;
import com.example.bibliotek.exeption.error_messeges.LoanErrorMessage;
import com.example.bibliotek.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;

    public List<LoanDto> getAllLoan() {
        List<Loan> loanList = loanRepository.findAll();
        List<LoanDto> loanDtoList = new ArrayList<>();
        loanDtoList = loanList.stream()
                .map(entity -> new LoanDto(entity.getLoanId(), entity.getReaderId(), entity.getBookId(), entity.getLoanDate(), entity.getReturnDate()))
                .collect(Collectors.toList());
        return loanDtoList;
    }
    
    public LoanDto getLoanById(Integer id) {
        Optional<Loan> optionalLoan = loanRepository.findById(id);
        if (!optionalLoan.isPresent()) {
            throw new LoanDoesntExistException(LoanErrorMessage.LOAN_NOT_EXIST);
        }
        Loan loan = optionalLoan.get();
        LoanDto loanDto = new LoanDto(loan.getLoanId(), loan.getReaderId(), loan.getBookId(), loan.getLoanDate(), loan.getReturnDate());
        return loanDto;

    }

    public LoanDto createLoan(LoanDto loanDto) {
        Loan loan = new Loan(null, loanDto.getReaderId(), loanDto.getBookId(), loanDto.getLoanDate(), loanDto.getReturnDate());
        Loan returnLoan = loanRepository.save(loan);
        LoanDto returnLoanDto = new LoanDto(returnLoan.getLoanId(), returnLoan.getReaderId(), returnLoan.getBookId(), returnLoan.getLoanDate(), returnLoan.getReturnDate());
        return returnLoanDto;
    }

    public LoanDto updateLoan(LoanDto loanDto) {
        Integer id = loanDto.getLoanId();
        Optional<Loan> optionalLoan = loanRepository.findById(id);
        if (!optionalLoan.isPresent()) {
            throw new RuntimeException("Loan not found");
        }
        Loan loan = new Loan(loanDto.getLoanId(), loanDto.getReaderId(), loanDto.getBookId(), loanDto.getLoanDate(), loanDto.getReturnDate());
        Loan returnLoan = loanRepository.save(loan);
        LoanDto returnLoanDto = new LoanDto(returnLoan.getLoanId(), returnLoan.getReaderId(), returnLoan.getBookId(), returnLoan.getLoanDate(), returnLoan.getReturnDate());
        return returnLoanDto;
    }

    public void deleteLoanById(Integer id) {
        Loan loan = loanRepository.findById(id).orElse(null);
        if (loan == null) {
            throw new RuntimeException("Loan not found");
        } else {
            loanRepository.delete(loan);
        }
    }

}
