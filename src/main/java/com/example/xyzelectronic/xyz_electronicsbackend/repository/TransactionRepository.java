package com.example.xyzelectronic.xyz_electronicsbackend.repository;

import com.example.xyzelectronic.xyz_electronicsbackend.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
