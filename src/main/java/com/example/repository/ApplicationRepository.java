package com.example.repository;

import java.util.List;

import com.example.model.Application;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends MongoRepository<Application, Long>{
Application findByAppId(@Param("appId") Long appId);

@Query("{'faculty_id': ?0}")
List<Application> findStudentsByFaculty(@Param("faculty_id") String faculty_id);
    
}
