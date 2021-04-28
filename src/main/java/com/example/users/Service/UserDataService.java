package com.example.users.Service;

import com.example.users.Entity.UserEntity;
import com.example.users.Repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

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
            user1.setPhoneNumber("9 9119119191");

            UserEntity user2 = new UserEntity();
            user2.setName("Petya");
            user2.setEmail("petya@mail.ru");
            user2.setPhoneNumber("8 8118118181");

            userRepository.save(user1);
            userRepository.save(user2);
        };
    }

    public Iterable<UserEntity> get() {
        return userRepository.findAll();
    }
}
