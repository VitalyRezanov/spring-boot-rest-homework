package com.netcracker.repository;

import com.netcracker.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "select distinct year(date) from order", nativeQuery = true)
    List<String> retrieveDifferentMonth();
}
