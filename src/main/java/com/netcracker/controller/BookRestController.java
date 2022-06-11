package com.netcracker.controller;

import com.netcracker.exception.ResourceNotFoundException;
import com.netcracker.model.Book;
import com.netcracker.repository.BookRepository;
import com.netcracker.response.DeleteResponse;
import com.netcracker.service.BookService;
import com.netcracker.service.EntityCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class BookRestController {

    @Autowired
    private BookRepository repository;

    @Autowired
    private EntityCrudService<Book> entityService;

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBook() {
        return entityService.getAllEntities(repository);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return entityService.getEntityById(id, repository);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return entityService.addEntity(book, repository);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<DeleteResponse> deleteBook(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return entityService.deleteEntity(id, repository);
    }

    @PatchMapping("/books/{id}")
    public ResponseEntity<Book> pathBook(@PathVariable(value = "id") Integer id, @RequestBody Book book) throws ResourceNotFoundException {
        return entityService.patchEntity(id, repository, book);
    }

    @PutMapping("/books")
    public List<Book> pathAll(@RequestBody List<Book> book) {
        return entityService.patchAllEntities(book, repository);
    }

    @GetMapping("/books/different-book")
    public List<String> getDifferentBook() {
        return bookService.retrieveDifferentBook(repository);
    }

    @GetMapping("/books/by-word")
    public List<String> getBookByWord(@RequestParam String word) {
        return bookService.retrieveBookByWord(repository, word);
    }
}
