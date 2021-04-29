package com.example.users.repository;

import com.example.users.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * nothing to see here
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
