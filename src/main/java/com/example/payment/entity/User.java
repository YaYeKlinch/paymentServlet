package com.example.payment.entity;


import java.util.Objects;

public class User {
    private long id;
    private String firs_name;
    private String last_name;
    private String username;
    private String password;
    private boolean active;
    private Role role;

    public User() {
    }

    public User(long id) {
        this.id = id;
    }

    public User(String firs_name, String last_name, String username, String password, Role role , boolean active) {
        this.firs_name = firs_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.active = active;
        this.role = role;
    }
    public User(long id, String firs_name, String last_name, String username, String password, Role role, boolean active) {
        this(firs_name, last_name, username, password, role, active);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirs_name(String firs_name) {
        this.firs_name = firs_name;
    }

    public String getFirs_name() {
        return firs_name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id && firs_name.equals(user.firs_name) && last_name.equals(user.last_name) && username.equals(user.username) && password.equals(user.password) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firs_name, last_name, username, password, role);
    }
}
