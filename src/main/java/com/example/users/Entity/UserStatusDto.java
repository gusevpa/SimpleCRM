package com.example.users.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
public class UserStatusDto {

    private Long id;
    private String status;
    private String prevStatus;

}