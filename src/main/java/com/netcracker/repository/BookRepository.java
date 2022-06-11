package com.netcracker.repository;

import com.netcracker.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "select distinct name,price from book", nativeQuery = true)
    List<String> retrieveDifferentBook();

    @Query(value = "select name, price from book b where b.name like word order by name ", nativeQuery = true)
    List<String> retrieveBookByWord(@Param("word") String word);
}
