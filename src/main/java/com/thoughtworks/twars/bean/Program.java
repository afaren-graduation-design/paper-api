package com.thoughtworks.twars.bean;

import java.util.List;

public class Program {
    private Integer id;
    private String programName;
    private List<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Program{"
                + "id=" + id
                + ", programName='" + programName + '\''
                + ", users=" + users
                + '}';
    }
}

