package com.netcracker.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "shop")
@Data
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shop")
    private int id;
    @Column(name = "shop_name")
    private String name;
    @Column(name = "shop_area")
    private String area;
    @Column(name = "commission")
    private double commission;
}
