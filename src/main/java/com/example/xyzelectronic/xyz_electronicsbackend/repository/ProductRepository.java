package com.example.xyzelectronic.xyz_electronicsbackend.repository;

import com.example.xyzelectronic.xyz_electronicsbackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByNameContaining(String str);
}
