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
public class Comment {
    
    private int comment_id;
    private String comment_content;
    private String comment_publish_date;
    private int user_id;
    private int post_id;
    // -----------------------------------            

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public String getComment_publish_date() {
        return comment_publish_date;
    }

    public void setComment_publish_date(String comment_publish_date) {
        this.comment_publish_date = comment_publish_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }
    
    
}
