package com.example.users.entity;

import lombok.Data;

import java.util.Objects;

@Data
public class UserStatusDto {

    private Long id;
    private String status;
    private String prevStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserStatusDto)) return false;
        UserStatusDto that = (UserStatusDto) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId()*123);
    }
}