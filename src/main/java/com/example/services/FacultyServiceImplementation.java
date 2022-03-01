package com.example.services;
import com.example.repository.FacultyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import com.example.model.Faculty;

@Service
public class FacultyServiceImplementation {
    
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

    public List<String> getCommentsById(String id){
        Optional<Faculty> fac = facRepo.findById(id);
        ArrayList<String> list = new ArrayList();
        list = (ArrayList<String>) fac.get().getComments();
        return list;
        
    }
    
}
