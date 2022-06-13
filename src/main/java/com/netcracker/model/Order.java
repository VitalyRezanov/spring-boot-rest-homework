package com.netcracker.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private int id;
    @Column(name = "date")
    private Date date;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "sum_order")
    private double sum;
    @Column(name = "id_shop")
    private int id_shop;
    @Column(name = "id_book")
    private int id_book;
    @Column(name = "id_customer")
    private int id_customer;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", quantity=" + quantity +
                ", sum=" + sum +
                ", id_shop=" + id_shop +
                ", id_book=" + id_book +
                ", id_customer=" + id_customer +
                '}';
    }
}
