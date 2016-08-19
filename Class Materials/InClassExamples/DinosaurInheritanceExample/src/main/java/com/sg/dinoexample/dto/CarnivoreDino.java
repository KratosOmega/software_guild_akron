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
public class CarnivoreDino extends Dinosaur {

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            System.out.println(food.getFlavor());
        } else {
            System.out.println("Yuck! I can't eat non-Meat things.");
        }
    }
    
}
