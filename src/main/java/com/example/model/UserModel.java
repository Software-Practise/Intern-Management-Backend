package com.example.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
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

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;


    private String major;
    private String status;
    private String level;
    private String offerLetter;
    private String facId;

    private long startDate;
    private long endDate;


    @PersistenceConstructor
    public UserModel( Long id, String fName, String lName, String nwId, String password, Collection<Role> roles) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.nwId = nwId;
        this.password = password;
        this.roles = roles;
    }

    
    public UserModel(Long id, String fName, String lName, String nwId, String password, Collection<Role> roles,
            String street, String city, String state, String zipCode, String phoneNumber, String major, String status,
            String level, String offerLetter, String facId, long startDate, long endDate) {
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
        this.phoneNumber = phoneNumber;
        this.major = major;
        this.status = status;
        this.level = level;
        this.offerLetter = offerLetter;
        this.facId = facId;
        this.startDate = startDate;
        this.endDate = endDate;
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
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public String getOfferLetter() {
        return offerLetter;
    }
    public void setOfferLetter(String offerLetter) {
        this.offerLetter = offerLetter;
    }
    public long getStartDate() {
        return startDate;
    }
    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }
    public long getEndDate() {
        return endDate;
    }
    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }


    public String getFaculty_id() {
        return facId;
    }


    public void setFaculty_id(String faculty_id) {
        this.facId = faculty_id;
    }

    


    
    
    
}
