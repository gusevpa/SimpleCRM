package com.example.users.Service;

import com.example.users.Entity.UserEntity;
import com.example.users.Repository.UserRepository;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.nio.charset.*;
import java.util.*;

@Service
public class UserDataService {

    private UserRepository userRepository;

    public UserDataService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    ApplicationRunner put() {
        return args -> {
            UserEntity user1 = new UserEntity();
            user1.setName("Vasya");
            user1.setEmail("vasya@mail.ru");
            user1.setPhone("9 9119119191");

           userRepository.save(user1);
        };
    }

    public Optional<UserEntity> getById(String id) {
        return userRepository.findById(Long.parseLong(id));
    }

    public Long saveUser(String userData) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;

        String request = new String(Base64.getDecoder().decode(userData));

        try {
            jsonNode = objectMapper.readTree(request);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String name = jsonNode.get("name").asText();
        String phone = jsonNode.get("phone").asText();
        String email = jsonNode.get("email").asText();

        return userRepository.save(new UserEntity(name, phone, email)).getId();
    }
}
