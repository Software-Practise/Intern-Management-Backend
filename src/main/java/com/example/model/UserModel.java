package com.example.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "users")
public class UserModel {

    @Id 
    private Long id;
    private String fName;
    private String lName;
    private String nwId;
    private String password;
    private Collection<Role> roles = new ArrayList<>();
    private String department;
    private String email;
    private List<UserModel> list;

    
    public UserModel( Long id, String fName, String lName, String nwId, String password, Collection<Role> roles) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.nwId = nwId;
        this.password = password;
        this.roles = roles;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getfName() {
        return fName;
    }
    public void setfName(String fName) {
        this.fName = fName;
    }
    public String getlName() {
        return lName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }
    public String getNwId() {
        return nwId;
    }
    public void setNwId(String nwId) {
        this.nwId = nwId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Collection<Role> getRoles() {
        return roles;
    }
    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<UserModel> getList() {
        return list;
    }
    public void setList(List<UserModel> list) {
        this.list = list;
    }


    

    
    
}
