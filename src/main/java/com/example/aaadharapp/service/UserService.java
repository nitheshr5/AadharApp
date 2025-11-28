package com.example.aaadharapp.service;

import org.springframework.data.domain.Page;

import com.example.aaadharapp.dto.CreateUserRequest;
import com.example.aaadharapp.model.User;

public interface UserService {

    User createUser(CreateUserRequest request);

    User getUser(Long id);

    Page<User> listUsers(int page, int size, String sortBy, String direction);
}
