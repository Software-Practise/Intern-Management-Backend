package com.example.demo.FacultyPack;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FacultyController{

    @Autowired
    FacultyService facultyservice;
    //FacultyRepository repo;

    @PostMapping("/addFaculty")
    public String addFaculty(@RequestBody Faculty fac){
        facultyservice.addFaculty(fac);
        //repo.save(fac);
        return "Added faculty";
    }

    @PutMapping("/updateFaculty")
    public String saveFaculty(@RequestBody Faculty fac){
        facultyservice.saveFaculty(fac);
        //repo.save(fac);
        return "Updated Faculty";
    }

    @GetMapping("/faculty")
    public List<Faculty> getAllFaculty(){
        //return repo.findAll();
        return facultyservice.getAllFaculty();

    }

    @GetMapping("/faculty/{id}")
    public Optional<Faculty> getFaculty(@PathVariable String id){
        //return repo.findById(id);
        return facultyservice.getFaculty(id);
    }

    @GetMapping("/faculty/fn={name}")
    public List<Faculty> getFacultyByFirstName(@PathVariable String name){
        //return repo.findByFname(name); 
        return facultyservice.getFacultyByFirstName(name);
    }

    @GetMapping("/faculty/ln={name}")
    public List<Faculty> getFacultyByLastName(@PathVariable String name){
        //return repo.findByLname(name);
        return facultyservice.getFacultyByLastName(name);
    }

    @GetMapping("/faculty/e={email}")
    public Optional<Faculty> getFacultyByEmail(@PathVariable String email){
        //return repo.findByEmail(email);
        return facultyservice.getFacultyByEmail(email);
    }

    @GetMapping("/faculty/dept={dept}")
    public List<Faculty> getFacultyByDepartment(@PathVariable String dept){
        //repo.findByDepartment(dept);
        return facultyservice.getFacultyByDepartment(dept);
    }

    @DeleteMapping("/deleteFaculty/{id}")
    public String removeFaculty(@PathVariable String id){
        facultyservice.removeFaculty(id);
        //repo.deleteById(id);
        return "Deleted Faculty";

    }


}

