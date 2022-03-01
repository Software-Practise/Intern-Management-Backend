package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;
import com.example.model.Faculty;

public interface FacultyRepository extends MongoRepository<Faculty, String>{
    
    public List<Faculty> findByFname(String fname);

    public List<Faculty> findByLname(String lname);

    public List<Faculty> findByDepartment(String department);

    public Optional<Faculty> findByEmail(String email);
    

}
