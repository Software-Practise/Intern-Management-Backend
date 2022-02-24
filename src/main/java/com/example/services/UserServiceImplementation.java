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
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    
    protected final Log log = LogFactory.getLog(getClass());

    @Override
    public void addRoleToUser(String nwId, String roleName) {
        UserModel user = userRepository.findBynwId(nwId);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
        log.info("Add user to role");
        for(Role x: user.getRoles()) log.info(user.getNwId() + " : " + x.getName());
        userRepository.save(user);
    }

    @Override
    public UserModel getUser(String nwId) {
        // TODO Auto-generated method stub
        log.info("Retrieve user from database");
        return userRepository.findBynwId(nwId);
    }

    @Override
    public List<UserModel> getUsers() {
        // TODO Auto-generated method stub
        log.info("Retrieve all users from database");
        return userRepository.findAll();
    }

    @Override
    public Role saveRole(Role role) {
        // TODO Auto-generated method stub
        log.info("Saving new role to the database");
        return roleRepository.save(role);
    }

    @Override
    public UserModel saveUser(UserModel userModel) {
        // TODO Auto-generated method stub
        log.info("Saving new User to the database");
        return userRepository.save(userModel);
    }

    
    public void clearDB() {
        userRepository.deleteAll();
        roleRepository.deleteAll();
    }
}
