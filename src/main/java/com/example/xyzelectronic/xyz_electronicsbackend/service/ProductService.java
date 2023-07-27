package com.example.xyzelectronic.xyz_electronicsbackend.service;

import com.example.xyzelectronic.xyz_electronicsbackend.entity.Product;

import java.util.List;

public interface ProductService {
    Product saveEmployee(Product product);

    List<Product> fetchAllProducts();

    Product getProductById(Long id);

    Product updateProductById(Long id, Product product);

    String deleteProductById(Long id);
}
