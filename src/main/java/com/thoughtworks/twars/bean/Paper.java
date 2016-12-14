package com.thoughtworks.twars.bean;

import java.lang.String;
import io.swagger.models.auth.In;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Paper {
    private int id;
    private int makerId;
    private List<Section> sections;
    private String paperName;
    private String description;
    private Integer createTime;
    private Integer programId;
    private boolean isDistribution;

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMakerId() {
        return makerId;
    }

    public void setMakerId(int makerId) {
        this.makerId = makerId;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public Map getResponseInfo() {
        Map result = new HashMap<>();

        result.put("id", id);
        result.put("paperName", paperName);

        List<Map> sectionsInfo = sections.stream()
                .map(section -> section.getResponseInfo())
                .collect(Collectors.toList());

        result.put("sections", sectionsInfo);

        return result;
    }


    public String getPaperName() {
        return paperName;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public boolean getIsDistribution() {
        return isDistribution;
    }

    public void setIsDistribution(boolean isDistribution) {
        this.isDistribution = isDistribution;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }
}


