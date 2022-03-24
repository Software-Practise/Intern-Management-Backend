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

@Service
public class StudentServiceImplementation implements StudentService {

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

    public void dropApplication(String nwId, Long appId) {
        UserModel user = userRepository.findBynwId(nwId);
        ArrayList<Application> applications = user.getApplications();
        for(Application app: applications) {
            if(app.getAppId() == appId) {
                app.setStatus("Dropped");
            }
        }
        
    }

    public Application getApplicationById(String nwId, Long appId){
        UserModel user = userRepository.findBynwId(nwId);
        //ArrayList<Application> applications = user.getApplications();
        return getApplicationById(nwId, appId);
    }

    public List<Comment> getComments(String nwId){
        return userRepository.findCommentBynwId(nwId);
    }

    public void addComment(String nwId, Comment comment){
        UserModel user = userRepository.findBynwId(nwId);
        user.getComments().add(comment);
        userRepository.save(user);
    }
    //for comment do the same as application but only need nwid, commentid, facid, and message which is the string comment, also need timestamps
}
