package com.example.users.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phone;
    private String email;

    public UserEntity() {
    }

    public UserEntity(String name, String phone, String email) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}