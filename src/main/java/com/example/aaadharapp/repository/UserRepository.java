package com.example.aaadharapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aaadharapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
