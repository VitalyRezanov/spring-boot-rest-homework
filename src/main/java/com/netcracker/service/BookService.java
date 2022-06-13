package com.netcracker.service;

import com.netcracker.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    public List<String> retrieveDifferentBook(BookRepository repository){
        return repository.retrieveDifferentBook();
    }
    public List<String> retrieveBookByWord(BookRepository repository, String word, Integer cost) {
        return repository.retrieveBookByWord("%" + word + "%",cost);
    }
    public List<String> retrieveBooksByQuantity(BookRepository repository, Integer quantity) {
        return repository.retrieveBooksByQuantity(quantity);
    }
}
