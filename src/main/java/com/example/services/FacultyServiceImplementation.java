package com.example.services;

import java.util.List;

import com.example.model.UserModel;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImplementation  implements FacultyService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    protected final Log log = LogFactory.getLog(getClass());

    @Override
    public List<UserModel> getAllFaculty() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserModel getFaculty(String nwId) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
