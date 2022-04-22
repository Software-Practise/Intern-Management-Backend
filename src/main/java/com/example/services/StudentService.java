package com.example.services;

import java.util.List;

import com.example.model.Application;
import com.example.model.EmployerModel;
import com.example.model.UserModel;
import com.example.model.Comment;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    UserModel getStudent(String nwId);
    Application setStatus(Long appId, String nwId, String status);
    List<UserModel> getStudents();
    List<Application> getStudentByFaculty(String nwid);
    List<UserModel> getStudentWithApplication();
    Application addApplication(String nwId, Long empId, Application application);
    Application dropApplication(Long appId, String nwId);
    EmployerModel saveEmployer(EmployerModel employer);
    List<Application> getAllApplications();
    Application getApplication(Long appId);
    Application addComment(String nwId, Comment comment, Long appId);



    
}
