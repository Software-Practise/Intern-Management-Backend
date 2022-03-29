package com.example.services;

import com.example.model.EmployerModel;
import com.example.repository.EmployerRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerServiceImplementation implements EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    protected final Log log = LogFactory.getLog(getClass());

    @Override
    public EmployerModel getEmployer(String employerId) {
        log.info("Retrieve client " + employerId + " from database");
        return employerRepository.findByEmployerId(employerId);
    }

    @Override
    public List<EmployerModel> getEmployers() {
        log.info("Retrieve all clients from database");
        return employerRepository.findAll();
    }

    @PreAuthorize("hasAnyRole('ROLE_FACULTY', 'ROLE_ADMIN')")
    public String deleteEmployer(String employerId) {
        log.info("Delete " + employerId + " from database");
        employerRepository.deleteByEmployerId(employerId);
        return "Deleted employer";
    }

    @PreAuthorize("hasAnyRole('ROLE_FACULTY', 'ROLE_ADMIN')")
    public String addEmployer(EmployerModel employer) {
        log.info("Add " + employer + " to database");
        employerRepository.save(employer);
        return "Added employer";
    }

    @PreAuthorize("hasAnyRole('ROLE_FACULTY', 'ROLE_ADMIN')")
    public String updateEmployer(EmployerModel employer) {
        log.info("Update " + employer + " in database");
        employerRepository.save(employer);
        return "Updated employer";
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

    // Realistically if this would be included, only admins should have access
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void clearDB() {
        log.info("DEBUG!!!\nCLEARE ALL CLIENTS FROM DATABASE");
        employerRepository.deleteAll();
    }
}
