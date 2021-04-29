package com.example.users.Entity;

import lombok.Data;

@Data
public class UserStatusDto {

    private Long id;
    private String status;
    private String prevStatus;

}