package com.learningspringboot.firstspringbootapp.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="imageurl")
    private String image_url;

    @Column(name="caption")
    private String caption;

    @Column(name = "description")
    private String description;

    @Column(name = "likes")
    private Long likes;

    @Column(name = "documenturl")
    private String document_url;

//    @Column(name = "user_post_fid")
//    private Long userId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"

    )
    private User user;


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

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Post(String image_url, String caption, String description, Long likes, String document_url, User user) {
        this.image_url = image_url;
        this.caption = caption;
        this.description = description;
        this.likes = likes;
        this.document_url = document_url;
        this.user = user;
    }
}
