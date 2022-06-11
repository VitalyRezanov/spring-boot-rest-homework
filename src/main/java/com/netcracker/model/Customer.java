package com.netcracker.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
public class Customer {

    @Id
    @Column(name = "id_customer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "surname", nullable = false)
    private String name;
    @Column(name = "area", nullable = false)
    private String area;
    @Column(name = "discount", nullable = false)
    private double discount;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", discount=" + discount +
                '}';
    }
}
