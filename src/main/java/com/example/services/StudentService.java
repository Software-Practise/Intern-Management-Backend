package com.example.services;

import java.util.List;

import com.example.model.Comment;
import com.example.model.Application;
import com.example.model.UserModel;

import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    UserModel getStudent(String nwId);
    List<UserModel> getStudents();
    List<UserModel> getStudentByFaculty(String nwid);
    Application getApplicationById(String nwId, Long appId);
    List<Comment> getComments(String nwId);

    
}
