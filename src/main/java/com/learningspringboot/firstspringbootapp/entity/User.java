package com.learningspringboot.firstspringbootapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String user_name;
    private String pass_word;
    private String confirm_Password;
    private String first_Name;
    private String last_Name;
    private Long dateOf_Birth;


    public User(String user_name, String pass_word, String confirm_Password, String first_Name, String last_Name, Long dateOf_Birth) {
        this.user_name = user_name;
        this.pass_word = pass_word;
        this.confirm_Password = confirm_Password;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.dateOf_Birth = dateOf_Birth;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public String getConfirm_Password() {
        return confirm_Password;
    }

    public void setConfirm_Password(String confirm_Password) {
        this.confirm_Password = confirm_Password;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public Long getDateOf_Birth() {
        return dateOf_Birth;
    }

    public void setDateOf_Birth(Long dateOf_Birth) {
        this.dateOf_Birth = dateOf_Birth;
    }
}
