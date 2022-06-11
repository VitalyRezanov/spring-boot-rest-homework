package com.netcracker.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "order")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private int id;
    @Column(name = "date")
    private String date;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "sum")
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
