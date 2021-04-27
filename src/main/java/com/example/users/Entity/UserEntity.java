package com.example.users.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "item")
public class UserEntity {
    @Id
    private long id;
    private String name;
    private String email;
    private String phoneNumber;

    public UserEntity() {

    }
}
