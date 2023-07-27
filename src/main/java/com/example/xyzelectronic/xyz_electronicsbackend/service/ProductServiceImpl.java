package com.example.xyzelectronic.xyz_electronicsbackend.service;

import com.example.xyzelectronic.xyz_electronicsbackend.entity.Product;
import com.example.xyzelectronic.xyz_electronicsbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveEmployee(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> fetchAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        return allProducts;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> employee = productRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        return null;
    }

    @Override
    public Product updateProductById(Long id, Product product) {
        Optional<Product> product1 = productRepository.findById(id);

        if (product1.isPresent()) {
            Product originalProduct = product1.get();

            if (Objects.nonNull(product.getName()) && !"".equalsIgnoreCase(product.getName())) {
                originalProduct.setName(product.getName());
            }
            if (Objects.nonNull(product.getPrice()) && product.getPrice() != 0) {
                originalProduct.setPrice(product.getPrice());
            }
            return productRepository.save(originalProduct);
        }
        return null;
    }

    @Override
    public String deleteProductById(Long id) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
            return "Product deleted successfully";
        }
        return "No such product in the database";
    }
}
