package com.example.bibliotek.controller;

import com.example.bibliotek.dto.ReaderDto;
import org.springframework.web.bind.annotation.*;
import com.example.bibliotek.service.ReaderService;

import java.util.List;

@RestController
@RequestMapping(value = "/reader")
public class ReaderController {

    private ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping
    public List<ReaderDto> getAllReaders() {
        return readerService.getAllReaders();
    }

    @GetMapping(value = "find/{id}")
    public ReaderDto getReaderById(@PathVariable Integer id) {
        return readerService.getReaderById(id);
    }

    @GetMapping(value = "/get")
    public ReaderDto getReaderByPhone(@RequestParam String phone) { ///reader/get?phone=0987654321  (reader id=2)
        return readerService.getReaderByPhone(phone);
    }

    @PostMapping
    public boolean createReader(@RequestBody ReaderDto readerDto) {
        return readerService.createReader(readerDto);
    }

    @PutMapping
    public ReaderDto updateReader(@RequestBody ReaderDto readerDto) {
        return readerService.updateReader(readerDto);
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteReader(@PathVariable Integer id) {
        return readerService.deleteReader(id);
    }

}
