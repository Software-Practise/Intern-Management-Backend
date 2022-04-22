package com.example.repository;

import com.example.model.EmployerModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends MongoRepository<EmployerModel, Long> {
    EmployerModel findByEmpId(@Param("empId") Long empId); // Searching for the String employerId, if you use the "findById" then it
    // expects a long based on how the database was set up.
    void deleteByEmployerId(Long empId);
}
