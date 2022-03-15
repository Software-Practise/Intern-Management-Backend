package com.example.repository;

import java.util.List;

import com.example.model.UserModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel, Long> {
    UserModel findBynwId(@Param("nwId") String nwId);
    
    @Query("{'roles':{'id': ?0, 'name': ?1}}")
    List<UserModel> findByRole(Long id, String name);

    @Query("{'faculty_id': ?0,'roles':{'id': ?1, 'name': ?2}}")
    List<UserModel> findStudentUnderFaculty(@Param("faculty_id") String faculty_id, Long id, String name);


}
