package com.example.xyzelectronic.xyz_electronicsbackend.controller;

import com.example.xyzelectronic.xyz_electronicsbackend.entity.Product;
import com.example.xyzelectronic.xyz_electronicsbackend.entity.Transaction;
import com.example.xyzelectronic.xyz_electronicsbackend.exception.ProductNotFoundException;
import com.example.xyzelectronic.xyz_electronicsbackend.exception.TransactionNotFoundException;
import com.example.xyzelectronic.xyz_electronicsbackend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class TransactionController {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @PostMapping("/transaction")
    public Transaction saveTransaction(@RequestBody Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @GetMapping("/transaction")
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @GetMapping("/transaction/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return transactionRepository.getReferenceById(id);
    }

    @PutMapping("/transaction/{id}")
    Transaction updateTransaction(@PathVariable Long id, @RequestBody Transaction updatedTrans){
        return transactionRepository.findById(id).map(product -> {
            product.setCustomerId(updatedTrans.getCustomerId());
            product.setDate(updatedTrans.getDate());
            product.setProductList(updatedTrans.getProductList());
            product.setPaymentMethod(updatedTrans.getPaymentMethod());
            product.setShippingAddress(updatedTrans.getShippingAddress());
            product.setStatus(updatedTrans.getStatus());
            return transactionRepository.save(product);
        }).orElseThrow(() -> new TransactionNotFoundException(id));
    }

    @DeleteMapping("/transaction/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionRepository.deleteById(id);
    }
}
