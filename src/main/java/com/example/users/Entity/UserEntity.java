package com.example.users.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TestUser")
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;

    public UserEntity() {
    }
}