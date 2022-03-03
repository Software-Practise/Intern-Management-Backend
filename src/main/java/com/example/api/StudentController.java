package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.UserModel;
import com.example.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping("/create")
	public void createStudent(@RequestBody UserModel student) {
		studentRepository.insert(student);
		
	}

	@PutMapping("/update")
	public String saveStudent(@RequestBody UserModel student){
		studentRepository.save(student);
		return "Updated Student";
	}
	
	@PostMapping("/delete/(id)")
	public void deleteStudent(@PathVariable String id) {
		studentRepository.deleteById(id);	
	}
	
	@GetMapping("/list")
	public List<UserModel> listStudents() {
		return studentRepository.findAll();
	}

	@GetMapping("/student/{id}")
	public Optional<UserModel> getStudent(@PathVariable String id){
		return studentRepository.findById(id);
	}


}
