package com.learningspringboot.firstspringbootapp.model;

import com.learningspringboot.firstspringbootapp.entity.User;

import javax.persistence.*;

public class PostRequestModel {

    private String image_url;

    private String caption;

    private String description;


    private Long likes;

    private String document_url;

//    @Column(name = "user_post_fid")
//    private Long userId;


    public PostRequestModel(String image_url, String caption, String description, Long likes, String document_url) {
        this.image_url = image_url;
        this.caption = caption;
        this.description = description;
        this.likes = likes;
        this.document_url = document_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getCaption() {
        return caption;
    }

    public String getDescription() {
        return description;
    }

    public Long getLikes() {
        return likes;
    }

    public String getDocument_url() {
        return document_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public void setDocument_url(String document_url) {
        this.document_url = document_url;
    }


}
