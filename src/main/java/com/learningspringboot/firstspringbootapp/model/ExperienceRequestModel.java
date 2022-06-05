package com.learningspringboot.firstspringbootapp.model;

import java.util.*;

public class ExperienceRequestModel {
    private String companyName;
    private String jobRole;
    private Long startDate;
    private Long endDate;
    private String jobDescription;
    private String MediaUrl;
    private boolean isPresent;

    public ExperienceRequestModel(String companyName, String jobRole, Long startDate, Long endDate, String jobDescription, String mediaUrl, boolean isPresent) {
        this.companyName = companyName;
        this.jobRole = jobRole;
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
        MediaUrl = mediaUrl;
        this.isPresent = isPresent;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getMediaUrl() {
        return MediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        MediaUrl = mediaUrl;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }
}
