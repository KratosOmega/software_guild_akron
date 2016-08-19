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
public class DinosaurApp {
    public static void main(String[] args) {
        Dinosaur gorgosaurus = new CarnivoreDino();
        Dinosaur edmontosaurus = new HerbivoreDino();
        
        Food pieceOfFood = new Meat();

        System.out.println("Feeding the Gorgosaurus steak:");
        gorgosaurus.eat(pieceOfFood);
        System.out.println("Feeding the Edmontosaurus steak:");
        edmontosaurus.eat(pieceOfFood);
        
        System.out.println("Moving on");
        gorgosaurus.move();
        
        pieceOfFood = new Plant();
     
        System.out.println("Feeding the Edmontosaurus plants:");
        edmontosaurus.eat(pieceOfFood);
        System.out.println("Feeding the Gorgosaurus plants:");
        gorgosaurus.eat(pieceOfFood);
        
    }
}
