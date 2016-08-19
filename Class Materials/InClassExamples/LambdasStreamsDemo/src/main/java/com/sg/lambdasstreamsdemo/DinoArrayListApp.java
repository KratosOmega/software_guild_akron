/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lambdasstreamsdemo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author softwareguild
 */
public class DinoArrayListApp {

    public static void main(String[] args) {
        // ArrayList example 
       List<Dinosaur> dinosaurHerd = new ArrayList<>();

        Dinosaur d1 = new Dinosaur();
        d1.setName("Pachy");
        d1.setBirthdate(LocalDate.parse("2010-01-01", DateTimeFormatter.ISO_DATE));

        dinosaurHerd.add(d1);

        Dinosaur d2 = new Dinosaur();
        d2.setName("Juniper");
        d2.setBirthdate(LocalDate.parse("2011-01-01", DateTimeFormatter.ISO_DATE));

        dinosaurHerd.add(d2);

        Dinosaur d3 = new Dinosaur();
        d3.setName("Alex");
        d3.setBirthdate(LocalDate.parse("1999-12-31", DateTimeFormatter.ISO_DATE));

        dinosaurHerd.add(d3);

        Dinosaur d4 = new Dinosaur();
        d4.setName("ALEX");
        d4.setBirthdate(LocalDate.parse("2013-12-12", DateTimeFormatter.ISO_DATE));

        dinosaurHerd.add(d4);

        // Find the dinosaurs younger than a given age
        long givenAge = 10;
        List<Dinosaur> youngDinos = dinosaurHerd
                .stream()
                .filter(dino -> dino.getDinoAge() < givenAge)
                .collect(Collectors.toList());

        // Find all dinosaurs named Alex - case-sensitive
        System.out.println("All dinosaurs named Alex (case-sensitive):");
        dinosaurHerd
                .stream()
                .filter(dino -> dino.getName().equals("Alex"))
                .forEach(d -> System.out.println(d.getName()));
        
        // Find all dinosaurs named Alex - case-insensitive - equalsIgnoreCase
        // Using the variable 'd' to understand the scope of the lambda variable
        System.out.println("All dinosaurs named Alex (case-insensitive):");
        dinosaurHerd
                .stream()
                .filter(d -> d.getName().equalsIgnoreCase("AleX"))
                .forEach(d -> System.out.println(d.getName()));
        
        // Collections can run forEach - you don't need streams necessarily
        // A stream is a type of Collection in java.util.Collections
        dinosaurHerd.forEach(d -> System.out.println(d.getName() + ": " + d.getBirthdate().toString()));
        
        // Calculate the average age of our dinosaurs
        double averageAge = dinosaurHerd
                .stream()
                .mapToLong(Dinosaur::getDinoAge)
                .average()
                .getAsDouble();
        
        System.out.println("The average age of our dinosaurs is: " + averageAge + " years.");
        
        // Rename young dinos to Youngster
        // To show using lambdas and streams to run a common method in forEach
        youngDinos.stream().forEach(dino -> dino.setName("Youngster"));
    }     
}
