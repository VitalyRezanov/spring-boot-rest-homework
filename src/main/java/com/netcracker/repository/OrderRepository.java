package com.netcracker.repository;

import com.netcracker.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "select distinct extract(month from o.date) from orders o", nativeQuery = true)
    List<String> retrieveDifferentMonth();
    @Query(value = "select id_order, (select shop_name from shop where orders.id_shop=id_shop)," +
            "(select surname from customer where orders.id_customer=id_customer) from orders", nativeQuery = true)
    List<String> retrieveNameShopAndCustomerFromOrder();
    @Query(value = "select date,(select surname from customer where orders.id_customer = id_customer)," +
            "(select discount from customer where orders.id_customer = id_customer)," +
            "(select b_name from book where orders.id_book = id_book)," +
            "quantity from orders", nativeQuery = true)
    List<String> retrieveBookAndCustomerFromOrder();
}
