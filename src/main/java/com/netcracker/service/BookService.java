package com.netcracker.service;

import com.netcracker.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    public List<String> retrieveDifferentBook(BookRepository repository){
        return repository.retrieveDifferentBook();
    }
    public List<String> retrieveBookByWord(BookRepository repository, String word) {
        return repository.retrieveBookByWord(word);
    }
}
