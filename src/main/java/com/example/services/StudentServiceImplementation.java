package com.example.services;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Application;
import com.example.model.EmployerModel;
import com.example.model.Role;
import com.example.model.UserModel;
import com.example.repository.ApplicationRepository;
import com.example.repository.EmployerRepository;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private EmployerRepository employerRepository;

    protected final Log log = LogFactory.getLog(getClass());

    @Override
    public UserModel getStudent(String nwId) {
        log.info("Retrieve user " + nwId + " from database");
        return userRepository.findBynwId(nwId);
    }

    @Override
    public List<UserModel> getStudents() {
        // TODO Auto-generated method stub
        
        String rtf = "ROLE_USER";
        Role role = roleRepository.findByName(rtf);
        Long role_id = role.getId();
        log.info("Role " + rtf + " id is " + role_id);
        List<UserModel> result = userRepository.findByRole(role_id, rtf);
        log.info("Retrieve ALL " + result.size() + " Students from database");
        return result;
    }

    @Override
    public List<UserModel> getStudentByFaculty(String nwid) {
        String rtf = "ROLE_USER";
        Role role = roleRepository.findByName(rtf);
        Long role_id = role.getId();
        log.info("Role " + rtf + " id is " + role_id);
        List<UserModel> result = userRepository.findStudentUnderFaculty(nwid, role_id, rtf);
        log.info("Retrieve ALL " + result.size() + " Students under faculty " + nwid);
        return result;
    }

    @Override
    public Application addApplication(String nwId, Long empId, Application application) {
        application.setNwId(nwId);
        application.setEmpId(empId);
        // UserModel user = userRepository.findBynwId(nwId);
        // user.getApplications().add(application);
        // log.info("Add new Application " + application.getAppId() + " to " + nwId );
        return applicationRepository.save(application);
    }

    @Override
    public Application dropApplication(Long appId) {
        Application app = applicationRepository.findByAppId(appId);
        app.setStatus("DROPPED");
        return applicationRepository.save(app);

        // UserModel user = userRepository.findBynwId(nwId);
        // ArrayList<Application> applications = user.getApplications();
        // for(Application app: applications) {
        //     if(app.getAppId() == appId) {
        //         app.setStatus("Dropped");
        //     }
        // }
        // log.info("Drop Application " + appId + " to " + nwId );
        // return userRepository.save(user);
        
    }

    @Override
    public EmployerModel saveEmployer(EmployerModel employer) {
        // UserModel user = userRepository.findBynwId(nwId);
        // ArrayList<Application> applications = user.getApplications();
        // for(Application app: applications) {
        //     if(app.getAppId() == appId) {
        //         app.setEmployer(employer);
        //     }
        // }
        // log.info("Added Employer for "+ nwId + " to " + appId );
        return employerRepository.save(employer);
    }

    
    
}
