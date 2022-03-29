package com.example.services;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Application;
import com.example.model.Role;
import com.example.model.UserModel;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import com.example.model.Comment;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;

@Service
public class StudentServiceImplementation implements StudentService {

    //protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

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

    public void addAplication(String nwId, Application application) {
        UserModel user = userRepository.findBynwId(nwId);
        user.getApplications().add(application);
        userRepository.save(user);
    }

    public void removeApplication(String nwId, String appId){
        UserModel user = userRepository.findBynwId(nwId);

    }

    public void dropApplication(String nwId, String appId) {
        UserModel user = userRepository.findBynwId(nwId);
        ArrayList<Application> applications = user.getApplications();
        for(Application app: applications) {
            if(app.getAppId() == appId) {
                app.setStatus("Dropped");
            }
        }
        
    }

    public Application getApplicationById(String nwId, String appId){
        UserModel user = userRepository.findBynwId(nwId);
        Application app = user.getApplications().get(0);
        for(Application a: user.getApplications()){
            if(a.getAppId() == appId){
                return a;
            }
        }
        //ArrayList<Application> applications = user.getApplications();
        return app;
    }

    public List<Comment> getComments(String nwId, String appId){
        ///UserModel user = userRepository.findBynwId(nwId);
        Application app = getApplicationById(nwId, appId);
        return app.getComments();
        //return userRepository.findCommentBynwId(nwId);
    }

    public void addComment(String nwId, Comment comment, String appId){
        UserModel user = userRepository.findBynwId(nwId);
        Application app = getApplicationById(nwId, appId);
        app.getComments().add(comment);
        //userRepository.delete(user);
        
        ArrayList<Application> applications = user.getApplications();
        //System.out.println("entered: length is: "+ applications.size());
        
        for(int i = 0; i < applications.size(); i++){
            if(applications.get(i).getAppId() == appId){
                applications.set(i, app);
                user.setApplications(applications);
                userRepository.save(user);
                //logger.info("Saved the user in the for loop");
                
            }
        }
        
        //addAplication(nwId, app);
        //return "Added application to " + nwId; 
        //userRepository.save(user);
    }
    //for comment do the same as application but only need nwid, commentid, facid, and message which is the string comment, also need timestamps

   
}
