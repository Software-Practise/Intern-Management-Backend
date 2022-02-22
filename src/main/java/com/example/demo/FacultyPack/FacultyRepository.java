package com.example.demo.FacultyPack;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface FacultyRepository extends MongoRepository<Faculty, String>{
    
    public List<Faculty> findByFname(String fname);

    public List<Faculty> findByLname(String lname);

    public List<Faculty> findByDepartment(String department);

    public Optional<Faculty> findByEmail(String email);
    

}
