package com.example.api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import com.example.services.FacultyServiceImplementation;
import com.example.model.Faculty;


@RestController
@RequestMapping("/faculty")
public class FacultyResource {
    @Autowired
    FacultyServiceImplementation facultyservice;
    //FacultyRepository repo;

    @PostMapping("/add")
    public String addFaculty(@RequestBody Faculty fac){
        facultyservice.addFaculty(fac);
        //repo.save(fac);
        return "Added faculty";
    }

    @PutMapping("/update")
    public String saveFaculty(@RequestBody Faculty fac){
        facultyservice.saveFaculty(fac);
        //repo.save(fac);
        return "Updated Faculty";
    }

    @GetMapping("/all")
    public List<Faculty> getAllFaculty(){
        //return repo.findAll();
        return facultyservice.getAllFaculty();

    }

    @GetMapping("/get/{id}")
    public Optional<Faculty> getFaculty(@PathVariable String id){
        //return repo.findById(id);
        return facultyservice.getFaculty(id);
    }

    @GetMapping("/get/fn={name}")
    public List<Faculty> getFacultyByFirstName(@PathVariable String name){
        //return repo.findByFname(name); 
        return facultyservice.getFacultyByFirstName(name);
    }

    @GetMapping("/get/ln={name}")
    public List<Faculty> getFacultyByLastName(@PathVariable String name){
        //return repo.findByLname(name);
        return facultyservice.getFacultyByLastName(name);
    }

    @GetMapping("/get/e={email}")
    public Optional<Faculty> getFacultyByEmail(@PathVariable String email){
        //return repo.findByEmail(email);
        return facultyservice.getFacultyByEmail(email);
    }

    @GetMapping("/get/dept={dept}")
    public List<Faculty> getFacultyByDepartment(@PathVariable String dept){
        //repo.findByDepartment(dept);
        return facultyservice.getFacultyByDepartment(dept);
    }

    @DeleteMapping("/delete/{id}")
    public String removeFaculty(@PathVariable String id){
        facultyservice.removeFaculty(id);
        //repo.deleteById(id);
        return "Deleted Faculty";

    }

    @PostMapping("/comments")
    public String addComments(@RequestBody Faculty fac){
        facultyservice.saveFaculty(fac);
        return "Updated Faculty: " + fac.getId();

    }

    @GetMapping("/comments/get/{id}")
    public List<String> getComments(@PathVariable String id){
        return facultyservice.getCommentsById(id);
    }
}
