/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.inheritancedemo;

import com.sg.inheritancedemo.dto.Animal;
import com.sg.inheritancedemo.dto.Dog;
import com.sg.inheritancedemo.dto.Retriever;
import com.sg.inheritancedemo.dto.SeaAnimal;
import com.sg.inheritancedemo.dto.SeaCucumber;

/**
 *
 * @author softwareguild
 */
public class AnimalController {

    public static void main(String[] args) {
        // Cuttlefish is a type of Animal
        // In our original example, Animal was a normal class
        // By making it abstract, we can no longer create an instance 
        // of it - we need to use classes that extend it
        
        //Animal cuttlefish = new Animal();
        //cuttlefish.move();
        //showDisplayName(cuttlefish);
        
        // Jellyfish is a type of SeaAnimal
        // that inherits from Animal
        // that overrides move()
        // that extends Animal with its own swim() class
        SeaAnimal jellyfish = new SeaAnimal();
        jellyfish.setName("Jelly");
        jellyfish.move();
        System.out.println("\nJellyfish");
        showTypes(jellyfish);

        // Seacucumber is a type of SeaCucumber
        // that inherits from SeaAnimal
        // extends SeaAnimal with its own defend() class
        // SeaAnimal inherits from Animal
        SeaCucumber seaCucumber = new SeaCucumber();
        seaCucumber.move();
        System.out.println("\nSea cucumber");
        showTypes(seaCucumber);

        Animal seaCucumber2 = (Animal) seaCucumber;
        // By casting this to an Animal class
        // seaCucumber2 only *shows* the properties and methods of the Animal class
        // Try using the dot operator with seaCucumber2 and verify this.
        
        // However, when we pass it to showTypes, the compiler knows that it is
        // of type SeaCucumber.  Yay... references!
        System.out.println("\nSea cucumber casted to Animal");
        showTypes(seaCucumber2);
        
        // Now let's bring in the dogs
        // RELEASE THE HOUNDS!
        
        Dog fido = new Dog("Woof!");
        Retriever doodles = new Retriever();
        
        System.out.println("\nFido");
        showTypes(fido);
        
        System.out.println("\nDoodles");
        showTypes(doodles);

    }

    public static void showTypes(Animal animal) {
        System.out.println("============================");
        System.out.println("Starting type: " + animal.getClass().getSimpleName());
        
        if (animal instanceof SeaCucumber){
            System.out.println("This is a sea cucumber.");
        }
        
        if (animal instanceof SeaAnimal){
            System.out.println("This is a sea animal.");
        }
        
        if (animal instanceof Dog){
            System.out.println("This is a dog.");
        }
        
        if (animal instanceof Animal)
        {
            System.out.println("This is an animal.");
        }
        
        animal.eat();
    }

}
