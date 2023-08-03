package com.example.xyzelectronic.xyz_electronicsbackend.controller;

import com.example.xyzelectronic.xyz_electronicsbackend.entity.Product;
import com.example.xyzelectronic.xyz_electronicsbackend.entity.ProductCategory;
import com.example.xyzelectronic.xyz_electronicsbackend.exception.ProductCategoryNotFoundException;
import com.example.xyzelectronic.xyz_electronicsbackend.exception.ProductNotFoundException;
import com.example.xyzelectronic.xyz_electronicsbackend.repository.ProductCategoryRepository;
import com.example.xyzelectronic.xyz_electronicsbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class ProductCategoryController {

    private final ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryController(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @PostMapping("/product")
    public ProductCategory saveCategory(@RequestBody ProductCategory category) {
        return productCategoryRepository.save(category);
    }

    @GetMapping("/product")
    public List<ProductCategory> getAllCategories() {
        return productCategoryRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public ProductCategory getCategoryById(@PathVariable Long id) {
        return productCategoryRepository.getReferenceById(id);
    }

    @PutMapping("/product/{id}")
    ProductCategory updateCategory(@PathVariable Long id, @RequestBody ProductCategory updatedCategory){
        return productCategoryRepository.findById(id).map(product -> {
            product.setDescription(updatedCategory.getDescription());
            product.setName(updatedCategory.getName());
            return productCategoryRepository.save(product);
        }).orElseThrow(() -> new ProductCategoryNotFoundException(id));
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productCategoryRepository.deleteById(id);
    }
}
