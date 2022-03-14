package com.example.services;

import java.util.List;

import com.example.model.UserModel;

import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    UserModel getStudent(String nwId);
    List<UserModel> getStudents();
    
}
