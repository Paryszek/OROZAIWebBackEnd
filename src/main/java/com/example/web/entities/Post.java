package com.example.web.entities;

import java.util.Date;


public class Post {


    private Long id;

    private String title;
    private String body;
    private Date dateCreated;



    public Post() {
        title = "dasdasd";
        body = "qweqwe12312";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}