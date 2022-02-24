package com.example.repository;

import com.example.model.Role;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, Long>{
    Role findByName(@Param("name") String name);
    
}
