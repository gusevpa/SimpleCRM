package com.example.users.Service;

import com.example.users.Entity.*;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Service
public class UserStatusService {

    Map<UserStatusDto, LocalDateTime> statusDtos = new HashMap<>();
    public Optional<UserStatusDto> updateUserStatus(UserStatusDto userStatusDto) {
        return Optional.of(new UserStatusDto());
    }

    @Bean
    @Scheduled(fixedDelay = 500)
    public void renewStatus(){

    }

}
