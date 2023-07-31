package com.example.xyzelectronic.xyz_electronicsbackend.controller;

import com.example.xyzelectronic.xyz_electronicsbackend.entity.Product;
import com.example.xyzelectronic.xyz_electronicsbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/employee")
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/employee")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productRepository.getReferenceById(id);
    }

    @PutMapping("/employee/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            return null;
        }
        //check if exists

        // Get the existing user from the optional (we know it exists)
        Product existingProduct = optionalProduct.get();

        // Apply the updates from the received user data to the existing user
        // You can also perform additional checks or validations here
        existingProduct.setName(optionalProduct.get().getName());
        existingProduct.setDescription(optionalProduct.get().getDescription());
        existingProduct.setPrice(optionalProduct.get().getPrice());
        existingProduct.setSupplier(optionalProduct.get().getSupplier());

        // Save the updated user to the database using the repository's save() method
        return productRepository.save(existingProduct);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productRepository.deleteById(id);
    }
}
