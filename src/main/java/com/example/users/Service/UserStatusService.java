package com.example.users.Service;

import com.example.users.Entity.*;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.stream.Stream;

@Service
public class UserStatusService {

    Map<UserStatusDto, LocalDateTime> statusDtos = new HashMap<>();

    /**
     * @param userStatusDto - сущность userStatusDto от контроллера с новым статусом
     * @return Optional.of UserStatusDto
     */
    public Optional<UserStatusDto> updateUserStatus(UserStatusDto userStatusDto) {

        if(statusDtos.containsKey(userStatusDto)) {
            return statusDtos.entrySet().stream()
                    .filter(e -> userStatusDto.getId().equals(e.getKey().getId()))
                    .peek(e -> {
                        e.getKey().setPrevStatus(e.getKey().getStatus());
                        e.getKey().setStatus(userStatusDto.getStatus());
                        e.setValue(LocalDateTime.now());
                    })
                    .map(Map.Entry::getKey)
                    .findFirst();
        } else {
            statusDtos.put(userStatusDto, LocalDateTime.now());
            return Optional.of(userStatusDto);
        }
    }

    @Bean
    @Scheduled(fixedDelay = 500)
    public void renewStatus(){
        statusDtos.entrySet().stream()
                .filter(e -> e.getKey().getStatus().equals("online"))
                .filter(e -> Duration.between(e.getValue(), LocalDateTime.now()).get(ChronoUnit.MINUTES) > 5)
                .peek(e -> {
                    e.getKey().setPrevStatus(e.getKey().getStatus());
                    e.getKey().setStatus("away");
                    e.setValue(LocalDateTime.now());
                })
                .close();
    }
}
