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
public class SeaCucumber extends SeaAnimal {
    
    @Override
    public void move(){
        // This shows how to call a method from the base class
        // The keyword 'super' in Java exposes the base class
        super.swim();
    }
    
    public void defend(){
        // pukes his guts out
    }
    
    @Override
    public void eat(){
        System.out.println("Sea cucumber gorge!  Yum!");
    }
}
