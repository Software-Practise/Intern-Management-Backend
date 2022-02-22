package com.example.services;

import java.util.List;

import com.example.model.Role;
import com.example.model.UserModel;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService{

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public void addRoleToUser(String username, String roleName) {
        UserModel user = userRepository.findByUserName(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
        log.info("Add role {} to user {}", roleName, username);
        
    }

    @Override
    public UserModel getUser(String username) {
        // TODO Auto-generated method stub
        log.info("Retrieve user {} from database", username);
        return userRepository.findByUserName(username);
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
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public UserModel saveUser(UserModel userModel) {
        // TODO Auto-generated method stub
        log.info("Saving new User {} to the database", userModel.getfName());
        return userRepository.save(userModel);
    }

    
    
}
