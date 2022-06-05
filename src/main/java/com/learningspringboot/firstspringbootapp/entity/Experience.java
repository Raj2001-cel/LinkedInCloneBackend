package com.learningspringboot.firstspringbootapp.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "experiences")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="companyname")
    private String companyName;

    @Column(name="jobrole")
    private String jobRole;

    @Column(name = "startdate")
    private Long startDate;

    @Column(name = "enddate")
    private Long endDate;

    @Column(name = "jobdescription")
    private String jobDescription;

    @Column(name = "mediaurl")
    private String mediaUrl;

    @Column(name = "ispresent")
    private boolean isPresent;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    private User user;


    public Experience(){

    }
    public Experience(String companyName, String jobRole, Long startDate, Long endDate, String jobDescription, String mediaUrl, boolean isPresent,User user) {
        super();
        this.companyName = companyName;
        this.jobRole = jobRole;
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
        this.mediaUrl = mediaUrl;
        this.isPresent = isPresent;
        this.user = user;
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
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        mediaUrl = mediaUrl;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }
}
