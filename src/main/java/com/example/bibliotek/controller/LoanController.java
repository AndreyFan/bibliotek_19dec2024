package com.example.bibliotek.controller;

import com.example.bibliotek.dto.LoanDto;
import com.example.bibliotek.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/loan")
public class LoanController {

    private final LoanService loanService;

    @GetMapping
    public List<LoanDto> getAllLoan(){
        return loanService.getAllLoan();
    }

    @GetMapping(value = "/find/{id}")
    public LoanDto getLoanById(@PathVariable Integer id){
        return loanService.getLoanById(id);
    }

    @PostMapping
    public LoanDto createLoan(@RequestBody LoanDto loanDto){
        return loanService.createLoan(loanDto);
    }

    @PutMapping
    public LoanDto updateLoan(@RequestBody LoanDto loanDto){
        return loanService.updateLoan(loanDto);
    }

    @DeleteMapping(value = "{id}")
    public void deleteLoanById(@PathVariable Integer id){
        loanService.deleteLoanById(id);
    }


}
