package com.thoughtworks.twars.bean;

import java.util.HashMap;
import java.util.Map;

public class BasicBlankQuiz {
    private int id;
    private String description;
    private String type;
    private String answer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Map toMap() {

        Map result = new HashMap();

        result.put("description", getDescription());
        result.put("type", getType());
        result.put("answer", getAnswer());

        return result;
    }
}
