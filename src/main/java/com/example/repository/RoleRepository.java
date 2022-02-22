package com.example.repository;

import com.example.model.Role;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, Long>{
    Role findByName(String name);
    
}
