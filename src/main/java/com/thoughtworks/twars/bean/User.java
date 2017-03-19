package com.thoughtworks.twars.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private int id;
    private String email;
    private String mobilePhone;
    private String password;
    private String userName;
    private List<Integer> roles;

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

    public List<Integer> getRoles() {
        return roles;
    }

    public void setRoles(List<Integer> roles) {
        this.roles = roles;
    }

    public Map toMap() {
        Map result = new HashMap<>();
        result.put("id",getId());
        result.put("email", getEmail());
        result.put("mobilePhone", getMobilePhone());

        // FIXME: 3/19/17
//        数据库 users 表存在 userName 字段，用户注册之后为 NULL
//        userDetail 表存在 name 字段，用户注册后正常写入
//        /user/{id}/detail 接口同时返回 userName 跟 name，
//        web-api 接收这个接口的响应时判断 userDetail 是否有字段为空，
//        如果有空字段，立即返回 false，前端页面跳转到 userCenter，让用户补充填写
//        这里的bug 为数据不一致，或者说，同一份数据存在了两个地方，导致不一致

//        result.put("userName", getUserName());
        result.put("role", roles);

        return result;
    }


}
