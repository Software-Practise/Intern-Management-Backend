package com.example.repository;

import com.example.model.EmployerModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends MongoRepository<EmployerModel, Long> {
    EmployerModel findByEmployerId(@Param("employerId") String employerId); // Searching for the String employerId, if you use the "findById" then it
    // expects a long based on how the database was set up.
    void deleteByEmployerId(String employerId);
}
