package com.example.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.StudentModel;

@Repository

public interface StudentRepository extends MongoRepository <StudentModel, String>{
	
	
}