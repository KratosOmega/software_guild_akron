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
public interface AnimalInterface {
    // In an interface, we can't specify a method body
    // All methods in an interface are - in their nature - abstract
    // They are ideas, not concretely defined
    // It is up to the classes that "implements" this interface
    // to add definitions for these methods.
    public void move();
    public void eat();
}




