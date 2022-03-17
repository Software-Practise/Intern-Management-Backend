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
    private String employerId;
    private String password;
    private Collection<Role> roles = new ArrayList<>();

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String email;
    private String company;
    private String position;



    @PersistenceConstructor
    public EmployerModel( Long id, String fName, String lName, String employerId, String password, Collection<Role> roles) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.employerId = employerId;
        this.password = password;
        this.roles = roles;
    }

    public EmployerModel(Long id, String fName, String lName, String employerId, String password, Collection<Role> roles,
            String street, String city, String state, String zipCode, String phoneNumber,
            String email, String company, String position) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.employerId = employerId;
        this.password = password;
        this.roles = roles;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.company = company;
        this.position = position;
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
    public String getEmployerId() {
        return employerId;
    }
    public void setEmployerId(String nwId) {
        this.employerId = nwId;
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
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
}
