package com.example.services;

import com.example.model.EmployerModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployerService {
    EmployerModel getEmployer(String employerId);
    List<EmployerModel> getEmployers();
//    UserDetails loadEmployerByUsername(String employerId);

    void clearDB();
//    void clearDbByEmployerId(String employerId);
}
