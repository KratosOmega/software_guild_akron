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
public class SeaAnimal extends Animal {
    private String name;
    
    // Anyone that inherits this SeaAnimal class
    // should be able to see swim()
    protected void swim(){
        
    }

    // Since Animal has been converted to an abstract base class
    // We need to give move() a definition
    @Override
    public void move() {
        // By default, if you have NetBeans implement move, it will add 
        // this line of code below, throwing an exception that it isn't done
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        // We'll have our move() for SeaAnimals call swim()
        swim();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
