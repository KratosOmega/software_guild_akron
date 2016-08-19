/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dinoexample.dto;

/**
 *
 * @author softwareguild
 */
/*

In your groups, design and code the following:

1. Create a Food abstract class that has a property of isEdible and can abstractly return its flavor (getFlavor) in a String.

2. Create an abstract base class for a Dinosaur. c

3. Create classes for Meat and Plant objects that inherit from Food.

4. Create CarnivoreDino and HerbivoreDino that extend the Dinosaur class, where CarnivoreDino can eat Meat objects and HerbivoreDino can eat Plant objects.

Submit 1 submission per group with code for each of the things requested above.
*/
public abstract class Food {
    private boolean isEdible = true;
    
    public abstract String getFlavor();

    /**
     * @return the isEdible
     */
    public boolean isIsEdible() {
        return isEdible;
    }

    /**
     * @param isEdible the isEdible to set
     */
    public void setIsEdible(boolean isEdible) {
        this.isEdible = isEdible;
    }
}
