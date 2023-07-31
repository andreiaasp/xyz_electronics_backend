package com.example.xyzelectronic.xyz_electronicsbackend.repository;

import com.example.xyzelectronic.xyz_electronicsbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
