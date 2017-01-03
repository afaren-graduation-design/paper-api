package com.thoughtworks.twars.bean;


import java.util.List;

public class Stack {
    private int stackId;
    private String title;
    private String description;
    private String definitionFile;
    private List<HomeworkQuiz> homeworkQuizList;

    public List<HomeworkQuiz> getHomeworkQuizList() {
        return homeworkQuizList;
    }

    public void setHomeworkQuizList(List<HomeworkQuiz> homeworkQuizList) {
        this.homeworkQuizList = homeworkQuizList;
    }

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
}
