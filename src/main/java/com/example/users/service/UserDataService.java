package com.example.users.service;

import com.example.users.entity.UserEntity;
import com.example.users.repository.UserRepository;
import com.fasterxml.jackson.databind.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDataService {

    private UserRepository userRepository;

    public UserDataService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     *
     * @param  - UserEntity, содержащий id пользователя, которого мы хотим вернуть из базы.
     *           В случае, если таковой в БД отсутствует - возвращаем ошибку из контроллера.
     * @return - JSON со всеми полями UserEntity
     */
    public Optional<UserEntity> getById(UserEntity userEntity) {
        return userRepository.findById(userEntity.getId());
    }

    /**
     *
     * @param userData - JSON, содержащий UserEntity.
     *                 В случае, если в нем содержится параметр id,
     *                 то происходит замена значений в БД на новые для заданного id.
     *                 В ином случае, соответственно, происходит создание новой
     *                 записи с присвоением (и возвратом) строкового значения, содержащего id.
     * @return JSON вида {"id":"1"}, где "1" - id нового (измененного) пользователя
     */
    public String saveUpdateUser(UserEntity userData) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.createObjectNode()
                .put("id", userRepository.save(userData).getId().toString()).toString();
    }
}
