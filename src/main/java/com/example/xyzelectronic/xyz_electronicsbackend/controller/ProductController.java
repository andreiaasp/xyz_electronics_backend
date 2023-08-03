package com.example.xyzelectronic.xyz_electronicsbackend.controller;

import com.example.xyzelectronic.xyz_electronicsbackend.entity.Product;
import com.example.xyzelectronic.xyz_electronicsbackend.entity.User;
import com.example.xyzelectronic.xyz_electronicsbackend.exception.ProductNotFoundException;
import com.example.xyzelectronic.xyz_electronicsbackend.exception.UserNotFoundException;
import com.example.xyzelectronic.xyz_electronicsbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("http://localhost:3000/")
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/product")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.getReferenceById(id);
    }

    @PutMapping("/product/{id}")
    Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProd){
        return productRepository.findById(id).map(product -> {
            product.setName(updatedProd.getName());
            product.setSupplier(updatedProd.getSupplier());
            product.setPrice(updatedProd.getPrice());
            product.setDescription(updatedProd.getDescription());
            return productRepository.save(product);
        }).orElseThrow(() -> new ProductNotFoundException(id));

    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
