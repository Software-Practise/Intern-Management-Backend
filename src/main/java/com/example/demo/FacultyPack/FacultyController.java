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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/management/api")
public class FacultyController{

    @Autowired
    FacultyRepository repo;

    @PutMapping("/updateFaculty")
    public String saveFaculty(@RequestBody Faculty fac){
        repo.save(fac);
        return "Updated Faculty";
    }

    @GetMapping("/faculty")
    public List<Faculty> getAllFaculty(){
        return repo.findAll();

    }

    @GetMapping("/faculty/{id}")
    public Optional<Faculty> getFaculty(@PathVariable String id){
        return repo.findById(id);
    }


}

