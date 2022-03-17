package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "employers")
public class EmployerModel {
    
    @Id
    private Long id;
    private String fName, lName;
    private String employerId;

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String email;
    

    private String companyName;



    @PersistenceConstructor
    public EmployerModel( Long id, String fName, String lName, String employerId) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.employerId = employerId;
    }

    public EmployerModel(Long id, String fName, String lName, String employerId, String street, 
            String city, String state, String zipCode, String phoneNumber,
            String email, String companyName) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.employerId = employerId;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
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
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
