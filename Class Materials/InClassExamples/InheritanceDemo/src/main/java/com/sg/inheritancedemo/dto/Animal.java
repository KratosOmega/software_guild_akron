/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.inheritancedemo.dto;

/**
 *
 * @author softwareguild
 */
public abstract class Animal {
    private String name;
    
    public abstract void move();
    
    // Abstract classes can have methods with method bodies
    // We can define a default action
    // And it can be overriden (see SeaCucumber.java)
    public void eat(){
        // use our mouths to eat
        System.out.println("Eating!  Yum!");
    }
    
}
