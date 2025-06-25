package com.example.blogApp.repository;

import com.example.blogApp.model.User;  
import org.springframework.data.mongodb.repository.MongoRepository;
public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}