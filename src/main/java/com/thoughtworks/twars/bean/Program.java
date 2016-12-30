package com.thoughtworks.twars.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Program {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map getResponseInfo() {
        Map result = new HashMap<>();
        result.put("id", id);
        result.put("name", name);
        return result;
    }

    @Override
    public String toString() {
        return "Program{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }
}

