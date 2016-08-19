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
public class Retriever extends Dog {

    public String favoriteToy;

    public Retriever() {
        // If we want to call our parent class's constructor
        // It looks like this:
        super("Woof");
        
        // However, we don't necessarily have to call a constructor
        this.favoriteToy = "stick";
    }
}
