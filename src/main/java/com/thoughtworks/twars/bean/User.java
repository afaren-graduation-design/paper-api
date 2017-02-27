package com.thoughtworks.twars.bean;

import java.util.HashMap;
import java.util.Map;

public class User {
    private int id;
    private String email;
    private String mobilePhone;
    private String password;
    private String role;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", email='" + email + '\''
                + '}';
    }

    public Map toMap() {
        Map result = new HashMap<>();
        result.put("email", getEmail());
        result.put("mobilePhone", getMobilePhone());
        result.put("password", getPassword());
        result.put("role", getRole());
        result.put("userName", getRole());

        return result;
    }


}
