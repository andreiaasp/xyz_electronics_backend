package com.example.xyzelectronic.xyz_electronicsbackend.exception;

public class ProductCategoryNotFoundException extends RuntimeException{

    public ProductCategoryNotFoundException(Long id) {
        super("Could not find the product category with id " + id);
    }
}
