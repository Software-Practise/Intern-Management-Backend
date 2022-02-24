package com.example.services;

import java.util.List;

import com.example.model.Role;
import com.example.model.UserModel;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserModel saveUser(UserModel userModel);
    Role saveRole(Role role);
    void addRoleToUser(String nwId, String roleName);
    UserModel getUser(String nwId);
    List<UserModel> getUsers();
    void clearDB();

    
}
 