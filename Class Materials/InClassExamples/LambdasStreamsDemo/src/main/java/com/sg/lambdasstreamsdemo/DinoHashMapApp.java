/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lambdasstreamsdemo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author softwareguild
 */
public class DinoHashMapApp {
    public static void main(String[] args) {
        
        // Create our HashMap
        Map<String,Dinosaur> dinosaurMap = new HashMap<>();
        
        // Create our herd
         Dinosaur d1 = new Dinosaur();
        d1.setName("Pachy");
        d1.setBirthdate(LocalDate.parse("2010-01-01", DateTimeFormatter.ISO_DATE));

        dinosaurMap.put(d1.getName(), d1);

        Dinosaur d2 = new Dinosaur();
        d2.setName("Juniper");
        d2.setBirthdate(LocalDate.parse("2011-01-01", DateTimeFormatter.ISO_DATE));

        dinosaurMap.put(d2.getName(), d2);

        Dinosaur d3 = new Dinosaur();
        d3.setName("Alex");
        d3.setBirthdate(LocalDate.parse("1999-12-31", DateTimeFormatter.ISO_DATE));

        dinosaurMap.put(d3.getName(), d3);

        Dinosaur d4 = new Dinosaur();
        d4.setName("ALEX");
        d4.setBirthdate(LocalDate.parse("2013-12-12", DateTimeFormatter.ISO_DATE));

        dinosaurMap.put(d4.getName(), d4);
        
        // Find all dinosaurs named Alex, case-insensitive
        System.out.println("All Alex dinosaurs:");
        dinosaurMap
                .values()
                .stream()
                .filter(d -> d.getName().equalsIgnoreCase("AlEx"))
                .forEach(d -> System.out.println(d.getName()));
        
        // Find the dinosaurs younger than a given age
        long givenAge = 10;
        Collection<Dinosaur> youngDinos = dinosaurMap
                .values()
                .stream()
                .filter(dino -> dino.getDinoAge() < givenAge)
                .collect(Collectors.toList());
       
        
        // Calculate the average age of our dinosaurs
        double averageAge = dinosaurMap
                .values()
                .stream()
                .mapToLong(Dinosaur::getDinoAge)
                .average()
                .getAsDouble();
        
        System.out.println("The average age of our dinosaurs is: " + averageAge + " years.");
        
    }
}
