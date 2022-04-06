package com.example.services;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Application;
import com.example.model.Comment;
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
import org.springframework.mail.MailException;
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

    @Autowired
    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    private NotificationService notification;

    protected final Log log = LogFactory.getLog(getClass());

    @Override
    public UserModel getStudent(String nwId) {
        log.info("Retrieve user " + nwId + " from database");
        return userRepository.findBynwId(nwId);
    }

    
    @Override
    public Application setStatus(Long appId, String nwId, String status) {
        Application app = applicationRepository.findByAppId(appId);
        app.setStatus(status);

        UserModel user = userRepository.findBynwId(nwId);
        ArrayList<Application> applications = user.getApplications();
        for(Application ap: applications) {
            log.info("enter"+ ap.getAppId() + " " + appId);
            if(ap.getAppId().equals(appId)) {
                ap.setStatus(status);
            }
        }
        log.info("Changed status to " + status);
        userRepository.save(user);
        // send Email notification
        try{
            notification.sendNotification(user);
        }
        catch(MailException e){
            
        }        
        return applicationRepository.save(app);


    }


    @Override
    public List<UserModel> getStudents() {
        
        String rtf = "ROLE_USER";
        Role role = roleRepository.findByName(rtf);
        Long role_id = role.getId();
        log.info("Role " + rtf + " id is " + role_id);
        List<UserModel> result = userRepository.findByRole(role_id, rtf);
        log.info("Retrieve ALL " + result.size() + " Students from database");
        return result;
    }

    @Override
    public List<Application> getStudentByFaculty(String nwid) {
        List<Application> res = applicationRepository.findStudentsByFaculty(nwid);
        return res;

        // String rtf = "ROLE_USER";
        // Role role = roleRepository.findByName(rtf);
        // Long role_id = role.getId();
        // log.info("Role " + rtf + " id is " + role_id);
        // List<UserModel> result = userRepository.findStudentUnderFaculty(nwid, role_id, rtf);
        // log.info("Retrieve ALL " + result.size() + " Students under faculty " + nwid);
        // return result;
    }

    @Override
    public Application addApplication(String nwId, Long empId, Application application) {

        application.setAppId(sequenceGenerator.generateSequence(Application.SEQUENCE_NAME));
        application.setNwId(nwId);
        application.setEmpId(empId);
        application.setComments(new ArrayList<>());
        application.setStatus("STARTED");
        UserModel user = userRepository.findBynwId(nwId);
        user.getApplications().add(application);
        log.info("Add new Application " + application.getAppId() + " to " + nwId );
        userRepository.save(user);
        return applicationRepository.save(application);
    }

    @Override
    public Application dropApplication(Long appId, String nwId) {
        Application app = applicationRepository.findByAppId(appId);
        app.setStatus("DROPPED");

        UserModel user = userRepository.findBynwId(nwId);
        ArrayList<Application> applications = user.getApplications();
        for(Application ap: applications) {
            if(ap.getAppId().equals(appId)) {
                ap.setStatus("DROPPED");
            }
        }
        log.info("Drop Application " + appId + " to " + nwId );
        userRepository.save(user);
        return applicationRepository.save(app);
        
    }

    public Application addComment(String nwId, Comment comment, Long appId){
        //int index = 0;
        comment.setCommId(sequenceGenerator.generateSequence(Comment.SEQUENCE_NAME));

        UserModel user = userRepository.findBynwId(nwId);
        ArrayList<Application> applications = user.getApplications();
        Application app = applicationRepository.findByAppId(appId);
        app.getComments().add(comment);

        for(int i = 0; i < applications.size(); i++){
            if(applications.get(i).getAppId().equals(appId)){
                log.info("appId:" + appId);
                applications.set(i, app);
                user.setApplications(applications);
                userRepository.save(user);
            }
        }
        userRepository.save(user);
        log.info("Added comment to nwId:" + nwId + " and appId: " + appId); 
        return applicationRepository.save(app);
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
        employer.setId(sequenceGenerator.generateSequence(Application.SEQUENCE_NAME));
        return employerRepository.save(employer);
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }


    @Override
    public Application getApplication(Long appId) {
        // TODO Auto-generated method stub
        return applicationRepository.findByAppId(appId);
    }

    

    
    
    
}
