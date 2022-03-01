package com.example.services;

import java.util.List;

import com.example.model.UserModel;

public interface FacultyService {
    List<UserModel> getAllFaculty();
    UserModel getFaculty(String nwId);
    
}
