package com.example.repository;

import com.example.model.UserModel;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserModel, Long> {
    UserModel findByUserName(String username);
    
}
