package com.example.xyzelectronic.xyz_electronicsbackend.exception;

public class TransactionNotFoundException extends RuntimeException{

    public TransactionNotFoundException(Long id) {
        super("Could not find the transaction with id " + id);
    }
}
