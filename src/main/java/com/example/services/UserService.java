package com.example.services;

import java.util.List;

import com.example.model.Role;
import com.example.model.UserModel;

public interface UserService {
    UserModel saveUser(UserModel userModel);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    UserModel getUser(String username);
    List<UserModel> getUsers();

    
}
 