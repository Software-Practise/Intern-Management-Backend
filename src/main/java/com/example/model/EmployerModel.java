package com.example.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "Employers")
public class EmployerModel {
    
    @Id
    private Long id;
    private String fName, lName;
    private String nwId;
    private String password;
    private Collection<Role> roles = new ArrayList<>();

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String workPhone;
    private String cellPhone;
    private String email;



    @PersistenceConstructor
    public EmployerModel( Long id, String fName, String lName, String nwId, String password, Collection<Role> roles) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.nwId = nwId;
        this.password = password;
        this.roles = roles;
    }

    public EmployerModel(Long id, String fName, String lName, String nwId, String password, Collection<Roles> roles,
            String street, String city, String state, String zipCode, String workPhone,
            String cellPhone, String email) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.nwId = nwId;
        this.password = password;
        this.roles = roles;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.workPhone = workPhone;
        this.cellPhone = cellPhone;
        this.email = email;
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
}
