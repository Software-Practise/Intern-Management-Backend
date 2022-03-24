package com.example.services;

import java.util.List;

import com.example.model.UserModel;

import org.springframework.stereotype.Service;

@Service
public interface FacultyService {
    
    UserModel getFaculty(String faculty_id);
    List<UserModel> getFaculty();
    String addFaculty(UserModel user);
    String updateFaculty(UserModel user);
    String deleteFaculty(String facId);
    List<UserModel> getFacultyByfName(String fName);
    List<UserModel> getFacultyBylName(String lName);
    UserModel getFacultyByEmail(String email);
    List<UserModel> getFacultyByDept(String dept);
}
