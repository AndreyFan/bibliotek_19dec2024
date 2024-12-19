package com.example.bibliotek.service;

import com.example.bibliotek.dto.LoanDto;
import com.example.bibliotek.dto.ReaderDto;
import com.example.bibliotek.entity.Book;
import com.example.bibliotek.entity.Loan;
import com.example.bibliotek.entity.Reader;
import com.example.bibliotek.exeption.BookDoesntExistException;
import com.example.bibliotek.exeption.error_messeges.ErrorMessage;
import com.example.bibliotek.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReaderService {

    public final ReaderRepository readerRepository;

    public List<ReaderDto> getAllReaders() {
        List<Reader> readers = readerRepository.findAll();
        List<ReaderDto> allReader = new ArrayList<>();
        for (Reader reader : readers) {
            ReaderDto currReaderDto = new ReaderDto(reader.getReaderId(), reader.getReaderName(), reader.getReaderPhone(), reader.getRegistrationDate(), reader.getEmail());
            allReader.add(currReaderDto);
        }
        return allReader;
    }

    public ReaderDto getReaderById(Integer id) {
        Reader reader = readerRepository.findById(id).orElse(new Reader());
        return new ReaderDto(reader.getReaderId(), reader.getReaderName(), reader.getReaderPhone(), reader.getRegistrationDate(), reader.getEmail());
    }

    public ReaderDto getReaderByPhone(String phone) {
        Optional<Reader> optionalReader = readerRepository.getReaderByPhone(phone);

        if (!optionalReader.isPresent()) {
            throw new RuntimeException("Phone " + phone + " not found");
        }

        Reader reader = optionalReader.get();
        ReaderDto readerDto = new ReaderDto(reader.getReaderId(), reader.getReaderName(), reader.getReaderPhone(), reader.getRegistrationDate(), reader.getEmail());
        return readerDto;
    }

    public boolean createReader(ReaderDto readerDto) {
        Reader reader = new Reader(null, readerDto.getReaderName(), readerDto.getReaderPhone(), readerDto.getRegistrationDate(), readerDto.getEmail());
        Reader savedReader = readerRepository.save(reader);
        return savedReader.getReaderId() != 0;
    }

    public ReaderDto updateReader(ReaderDto readerDto) {
        Integer id = readerDto.getReaderId();
        Optional<Reader> optionalReader = readerRepository.findById(id);
        if (!optionalReader.isPresent()) {
            throw new RuntimeException("Reader not found");
        }
        Reader reader = new Reader( readerDto.getReaderId(), readerDto.getReaderName(), readerDto.getReaderPhone(), readerDto.getRegistrationDate(), readerDto.getEmail());
        Reader returnReader = readerRepository.save(reader);
        ReaderDto returnReaderDto = new ReaderDto(returnReader.getReaderId(), returnReader.getReaderName(), returnReader.getReaderPhone(), returnReader.getRegistrationDate(), returnReader.getEmail());
        return returnReaderDto;
    }

    public boolean deleteReader(Integer id) {
        readerRepository.deleteById(id);
        Reader reader = readerRepository.findById(id).orElse(new Reader());
        return reader.getReaderId() == 0;
    }

}
