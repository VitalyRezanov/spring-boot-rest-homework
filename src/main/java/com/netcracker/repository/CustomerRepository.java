package com.netcracker.repository;

import com.netcracker.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select distinct area from customer", nativeQuery = true)
    List<String> retrieveDifferentArea();
    @Query(value = "select surname,discount from customer c where c.area =:area", nativeQuery = true)
    List<String> retrieveNameDiscount(@Param("area") String area);
}
