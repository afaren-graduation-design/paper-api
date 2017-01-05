package com.thoughtworks.twars.bean;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stack {
    private int stackId;
    private String title;
    private String description;
    private String definitionFile;

    public int getStackId() {
        return stackId;
    }

    public void setStackId(int stackId) {
        this.stackId = stackId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDefinitionFile() {
        return definitionFile;
    }

    public void setDefinitionFile(String definitionFile) {
        this.definitionFile = definitionFile;
    }

    public Map getResponseInfo() {
        Map result = new HashMap<>();
        result.put("stackId", stackId);
        result.put("title", title);
        result.put("description", description);
        result.put("definitionFile", definitionFile);
        return result;
    }
}
