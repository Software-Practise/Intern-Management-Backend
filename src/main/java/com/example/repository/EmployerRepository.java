package com.example.repository;

import com.example.model.EmployerModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends MongoRepository<EmployerModel, Long> {
    EmployerModel findByemployerId(@Param("employerId") String employerId);

}
