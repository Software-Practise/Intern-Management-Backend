package com.example.services;

import java.util.List;

import com.example.model.UserModel;

import org.springframework.stereotype.Service;

@Service
public interface FacultyService {
    
    UserModel getFaculty(String faculty_id);
    List<UserModel> getFaculty();
}
