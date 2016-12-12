package com.thoughtworks.twars.bean;

public class HomeworkQuiz {
    private int id;
    private String description;
    private String evaluateScript;
    private String templateRepository;
    private int makerId;
    private int createTime;
    private String homeworkName;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMakerId() {
        return makerId;
    }

    public void setMakerId(int makerId) {
        this.makerId = makerId;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public String getHomeworkName() {
        return homeworkName;
    }

    public void setHomeworkName(String homeworkName) {
        this.homeworkName = homeworkName;
    }

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

    public String getEvaluateScript() {
        return evaluateScript;
    }

    public void setEvaluateScript(String evaluateScript) {
        this.evaluateScript = evaluateScript;
    }

    public String getTemplateRepository() {
        return templateRepository;
    }

    public void setTemplateRepository(String templateRepository) {
        this.templateRepository = templateRepository;
    }
}
