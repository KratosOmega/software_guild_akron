/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.teamyoghfinalmasteryproject.model;

/**
 *
 * @author Kratos
 */
public class Post {

    private int post_id;
    private String post_title;
    private String post_content;
    private String post_publish_date;
    private String post_create_date;
    private int user_id;
    private int category_id;
    private int status_id;

    // -----------------------------------        
    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public String getPost_publish_date() {
        return post_publish_date;
    }

    public void setPost_publish_date(String post_publish_date) {
        this.post_publish_date = post_publish_date;
    }

    public String getPost_create_date() {
        return post_create_date;
    }

    public void setPost_create_date(String post_create_date) {
        this.post_create_date = post_create_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

}
