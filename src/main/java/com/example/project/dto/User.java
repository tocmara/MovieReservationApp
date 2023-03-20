package com.example.project.dto;

import java.util.Date;

public class User {

    private String name;
    private Date date;
    private String email;

    public User(String name, Date date, String email) {
        this.name = name;
        this.date = date;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

