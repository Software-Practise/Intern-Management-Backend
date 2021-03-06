package com.example.services;

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
import org.springframework.security.crypto.password.PasswordEncoder;
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

    //@Autowired
    PasswordEncoder passwordEncoder;

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

    public List<Application> getCompleteApps(String nwId){
        ArrayList<Application> compApps = new ArrayList<>();
        ArrayList<Application> allApps = applicationRepository.findBynwId(nwId);
        for(Application app: allApps){
            log.info("Application id = " + app.getAppId() + " Application status = " + app.getStatus());
            if(app.getStatus().equals("COMPLETE")){
                compApps.add(app);
            }
        }
        return compApps;
    }

    public List<Application> getInCompleteApps(String nwId){
        ArrayList<Application> compApps = new ArrayList<>();
        ArrayList<Application> allApps = applicationRepository.findBynwId(nwId);
        for(Application app: allApps){
            log.info("Application id = " + app.getAppId() + " Application status = " + app.getStatus());
            if(!(app.getStatus().equals("COMPLETE") || app.getStatus().equals("DROPPED") )){
                compApps.add(app);
            }
        }
        return compApps;
    }

    public List<Application> getApps(String nwId){
        ArrayList<Application> allApps = applicationRepository.findBynwId(nwId);
        return allApps;
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
    public UserModel updateUser(String nwId, UserModel user){
        //UserModel test = userRepository.findBynwId(nwId);
        //test.setPhoneNumber(user.getPhoneNumber());
        //test.setStreet(user.getStreet());
        UserModel user_to_update = userRepository.findBynwId(nwId);
        user_to_update.setCity(user.getCity());
        try {
            user_to_update.setPassword(passwordEncoder.encode(user.getPassword()));
        } catch (Exception e){
            log.error("Failed to encode password " + e);

        }
        user_to_update.setStreet(user.getStreet());
        user_to_update.setState(user.getState());
        user_to_update.setZipCode(user.getZipCode());
        user_to_update.setPhoneNumber(user.getPhoneNumber());

        return userRepository.save(user_to_update);
    }

    @Override
    public List<UserModel> getStudentWithApplication() {
       List<UserModel> allApp = userRepository.findAll();
       List<UserModel> result = new ArrayList<>();
       for(UserModel user : allApp) {
           if(user.getApplications().size() != 0) {
               result.add(user);
           }

       }
        return result;
    }

    

    
    
    
}
