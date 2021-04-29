package com.example.users.entity;

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
    @Column(unique = true, nullable = false)
    private String email;

}