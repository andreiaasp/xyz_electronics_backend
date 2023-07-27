package com.example.xyzelectronic.xyz_electronicsbackend.controller;

import com.example.xyzelectronic.xyz_electronicsbackend.entity.Product;
import com.example.xyzelectronic.xyz_electronicsbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/employee")
    public Product saveEmployee(@RequestBody Product product) {
        return productService.saveEmployee(product);
    }

    @GetMapping("/employee")
    public List<Product> getAllEmployees() {
        return productService.fetchAllProducts();
    }

    @GetMapping("/employee/{id}")
    public Product getEmployeeById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/employee/{id}")
    public Product updateEmployee(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProductById(id, product);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        return productService.deleteProductById(id);
    }
}
