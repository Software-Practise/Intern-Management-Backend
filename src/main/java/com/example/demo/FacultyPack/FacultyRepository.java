package com.example.demo.FacultyPack;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FacultyRepository extends MongoRepository<Faculty, String>{
    
}
