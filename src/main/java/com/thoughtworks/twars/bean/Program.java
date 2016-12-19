package com.thoughtworks.twars.bean;

public class Program {
    private Integer id;
    private String programName;

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

    @Override
    public String toString() {
        return "Program{"
                + "id=" + id
                + ", programName='" + programName + '\''
                + '}';
    }
}

