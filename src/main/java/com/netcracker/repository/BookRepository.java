package com.netcracker.repository;

import com.netcracker.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "select distinct b_name,price from book", nativeQuery = true)
    List<String> retrieveDifferentBook();

    @Query(value = "select b_name, price from book b where upper(b.b_name) " +
            "like upper(:word) or b.price >:cost order by b_name desc,price desc ", nativeQuery = true)
    List<String> retrieveBookByWord(@Param("word") String word, @Param("cost") Integer cost);
}
