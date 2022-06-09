package com.netcracker.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private int id;
    @Column(name = "b_name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "b_storage")
    private String storage;
    @Column(name = "quantity")
    private int quantity;
}
