package com.example.payment.entity.dto;

import com.example.payment.entity.Role;

public class UserDto {

    private String firs_name;
    private String last_name;
    private String username;
    private String password;
    private String confirmedPassword;

    public UserDto(){

    }
    public UserDto(String firs_name, String last_name, String username, String password, String confirmedPassword) {
        this.firs_name = firs_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
    }

    public String getFirs_name() {
        return firs_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }


    public void setFirs_name(String firs_name) {
        this.firs_name = firs_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

}
