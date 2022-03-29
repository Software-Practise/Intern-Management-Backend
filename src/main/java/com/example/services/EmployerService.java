package com.example.services;

import com.example.model.EmployerModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployerService {
    EmployerModel getEmployer(String employerId);
    List<EmployerModel> getEmployers();
    String deleteEmployer(String employerId);
    String updateEmployer(EmployerModel employer);
    String addEmployer(EmployerModel employer);

    void clearDB();
}
