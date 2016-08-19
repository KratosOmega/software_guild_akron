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

2. Create an abstract base class for a Dinosaur.  It has a name, the ability to eat a Food object, and the ability to move.

3. Create classes for Meat and Plant objects that inherit from Food.

4. Create CarnivoreDino and HerbivoreDino that extend the Dinosaur class, where CarnivoreDino can eat Meat objects and HerbivoreDino can eat Plant objects.

Submit 1 submission per group with code for each of the things requested above.
*/
public abstract class Dinosaur {
 private String name;
 
 public abstract void eat(Food food);
 
 public void move(){
     System.out.println("Moving DINOSAUR STYLE!");
 }
}
