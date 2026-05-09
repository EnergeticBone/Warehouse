package com.bone.warehouse.repository;

import com.bone.warehouse.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUsernameAndIsDeletedFalse(String username);
    Optional<User> findByUsername(String username);
}
