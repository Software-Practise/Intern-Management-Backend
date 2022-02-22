package com.example.demo.FacultyPack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
    @Autowired
    FacultyRepository facRepo;

    public void addFaculty(Faculty fac){
        facRepo.save(fac);
        //return "Added faculty";
    }

    public String saveFaculty(Faculty fac){
        facRepo.save(fac);
        return "Updated Faculty";
    }

    
    public List<Faculty> getAllFaculty(){
        return facRepo.findAll();

    }

    
    public Optional<Faculty> getFaculty(String id){
        return facRepo.findById(id);
    }

    
    public String removeFaculty(String id){
        facRepo.deleteById(id);
        return "Deleted Faculty";

    }

    
    public List<Faculty> getFacultyByFirstName(String name){
        return facRepo.findByFname(name);
    }

    
    public List<Faculty> getFacultyByLastName(String name){
        return facRepo.findByLname(name);
    }

    
    public Optional<Faculty> getFacultyByEmail(String email){
        return facRepo.findByEmail(email);
    }

    
    public List<Faculty> getFacultyByDepartment(String dept){
        return facRepo.findByDepartment(dept);
    }
    
}
