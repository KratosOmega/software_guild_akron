/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sampleplayground;

/**
 *
 * @author softwareguild
 */
public class MathOverloading {
    // The question was can we add an int and a double 
    // The answer - only if the return value is a double.
    public double add(int num1, double num2){
        return num1 + num2;
    }
    
    /* This can't be done because:
    - Going from int to double is okay - 18 would change to 18.0
    - Going from double to int has a chance of losing data so it won't do it
     18.00001 would convert to 18, and 18.00001 is not the same as 18
    
    public int add(double num1, int num2){
        return num1 + num2;
    }*/
}
