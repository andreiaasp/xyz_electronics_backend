package com.example.xyzelectronic.xyz_electronicsbackend.repository;

import com.example.xyzelectronic.xyz_electronicsbackend.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
