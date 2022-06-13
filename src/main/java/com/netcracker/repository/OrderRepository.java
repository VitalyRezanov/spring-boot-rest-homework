package com.netcracker.repository;

import com.netcracker.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
            "quantity from orders order by orders.date desc", nativeQuery = true)
    List<String> retrieveBookAndCustomerFromOrder();

    @Query(value = "select id_order, sum_order ,(select surname from customer where orders.id_customer=id_customer)," +
            "date from orders where sum_order>:sum", nativeQuery = true)
    List<String> retrieveOrderLessSum(@Param(value = "sum") Double sum);

    @Query(value = "select customer.surname, shop.shop_area ,orders.date from customer,shop,orders " +
            "where orders.id_customer=customer.id_customer and orders.id_shop=shop.id_shop " +
            "and shop.shop_area=customer.area and extract(month from orders.date)>=:month " +
            "and extract(year from orders.date)>=:year " +
            "and customer.id_customer=:id", nativeQuery = true)
    List<String> retrieveOrderByAreaShopAndCustomer(@Param(value = "id") Integer id,
                                                    @Param(value = "month") Integer month,
                                                    @Param(value = "year") Integer year);
}
