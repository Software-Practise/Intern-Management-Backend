package com.example.Filter;

public class UsernameAndPasswordAuthenticationRequest {

    private String nwId;
    private String password;

    public UsernameAndPasswordAuthenticationRequest() {
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
    
}
