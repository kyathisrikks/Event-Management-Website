package com.example.wedding_web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wedding_web.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String name);
}