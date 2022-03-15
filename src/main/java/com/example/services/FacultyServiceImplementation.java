
package com.example.services;

import java.util.List;

import com.example.model.Role;
import com.example.model.UserModel;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImplementation implements FacultyService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    protected final Log log = LogFactory.getLog(getClass());

    @Override
    public UserModel getFaculty(String faculty_id) {
        log.info("Retrieve user " + faculty_id + " from database");
        return userRepository.findByfacId(faculty_id);
    }

    @Override
    public List<UserModel> getFaculty() {
        // TODO Auto-generated method stub
        
        String rtf = "ROLE_FACULTY";
        Role role = roleRepository.findByName(rtf);
        Long role_id = role.getId();
        log.info("Role " + rtf + " id is " + role_id);
        List<UserModel> result = userRepository.findByRole(role_id, rtf);
        log.info("Retrieve ALL " + result.size() + " Faculty from database");
        return result;
    }
/*
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

    */
    
}
