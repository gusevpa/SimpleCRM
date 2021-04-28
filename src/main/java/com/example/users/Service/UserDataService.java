package com.example.users.Service;

import com.example.users.Entity.UserEntity;
import com.example.users.Repository.UserRepository;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDataService {

    private UserRepository userRepository;

    public UserDataService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserEntity> getById(String id) {
        return userRepository.findById(Long.parseLong(id));
    }

    public String saveUpdateUser(UserEntity userData) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.createObjectNode()
                .put("id", userRepository.save(userData).getId().toString()).toString();
    }
}
