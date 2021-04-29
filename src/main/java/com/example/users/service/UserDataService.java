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
     * @param id - строковое значение id пользователя, которого мы хотим вернуть из базыю
     *           В случае, если таковой в БД отсутствует - возвращаем ошибку из контроллера.
     * @return - JSON со всеми полями UserEntity
     */
    public Optional<UserEntity> getById(String id) {
        return userRepository.findById(Long.parseLong(id));
    }

    /**
     *
     * @param userData - JSON, содержащий UserEntity.
     *                 В случае, если в нем содержится параметр id,
     *                 то проиходит замена значений в БД на новые для заданного id.
     *                 В ином случае, соответственно, происходит создание новой
     *                 записи с присвоением (и возвратом) строкового значения, содержащего id.
     * @return JSON вида {"id":"1"}
     */
    public String saveUpdateUser(UserEntity userData) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.createObjectNode()
                .put("id", userRepository.save(userData).getId().toString()).toString();
    }
}
