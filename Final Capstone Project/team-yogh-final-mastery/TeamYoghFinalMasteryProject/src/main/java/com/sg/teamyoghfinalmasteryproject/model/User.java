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
public class User {
    private int user_id;
    private String user_name;
    private String user_password;
    private int user_enabled;
    
    // -----------------------------------    

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public int getUser_enabled() {
        return user_enabled;
    }

    public void setUser_enabled(int user_enabled) {
        this.user_enabled = user_enabled;
    }
}
