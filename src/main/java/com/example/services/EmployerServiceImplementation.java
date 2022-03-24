package com.example.services;

import com.example.model.EmployerModel;
import com.example.repository.EmployerRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployerServiceImplementation implements EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    protected final Log log = LogFactory.getLog(getClass());

    @Override
    public EmployerModel getEmployer(String employerId) {
        log.info("Retrieve client " + employerId + " from database");
        return employerRepository.findByemployerId(employerId);
    }

    @Override
    public List<EmployerModel> getEmployers() {
        log.info("Retrieve all clients from database");
        return employerRepository.findAll();
    }

//    @Override
//    public UserDetails loadEmployerByUsername(String employerId) throws UsernameNotFoundException {
//        EmployerModel employer = employerRepository.findByemployerId(employerId);
//        if(employer == null) {
//            log.error("Employer not found in database");
//            throw new UsernameNotFoundException("Employer not found in databse");
//        } else {
//            log.info("Employer found in database " + employerId);
//        }
//        return null;
//    }

    @Override
    public void clearDB() {
        employerRepository.deleteAll();
    }

//    @Override
//    public void clearDbByEmployerId(String employerId) {
//        employerRepository.deleteAll();
//    }
}
