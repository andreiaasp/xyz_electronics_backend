package com.example.xyzelectronic.xyz_electronicsbackend.entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    private int price;
    private String description;
    private String supplier;

    public Product() {
    }

    public Product(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NonNull
    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(@NonNull String supplier) {
        this.supplier = supplier;
    }

    public Long getId() {
        return id;
    }

}
