package com.example.services;

import java.util.List;

import com.example.model.Application;
import com.example.model.EmployerModel;
import com.example.model.UserModel;

import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    UserModel getStudent(String nwId);
    List<UserModel> getStudents();
    List<UserModel> getStudentByFaculty(String nwid);
    Application addApplication(String nwId, Application application);
    Application dropApplication(Long appId);
    UserModel addEmployerToStudent(String nwId, EmployerModel employer);


    
}
