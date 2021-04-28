package com.example.users.Repository;

import com.example.users.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * nothing to see here
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
