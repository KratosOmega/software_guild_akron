/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals2;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Kratos
 */

public class StateCapitals2 {

    public static void main(String[] args) throws FileNotFoundException {
        long filter;

        HashMap<String, Capital> stateCapital = new HashMap<>();
        Scanner fileScanner = new Scanner(new BufferedReader(new FileReader("StateCapital_Data.tsv")));
        Scanner input = new Scanner(System.in);

        csvToHashMap(stateCapital, fileScanner);
        printHashMap(stateCapital);

        System.out.print("\n\nEnter a population filter: ");
        filter = input.nextLong();
        printHashMap(filterHashMap(stateCapital, filter));
    }

    public static void csvToHashMap(HashMap<String, Capital> stateCapital, Scanner fileScanner) {

        String line = "";
        while (fileScanner.hasNextLine()) {
            line = fileScanner.nextLine();
            String[] spreadSheet = line.split("\t");
            stateCapital.put(spreadSheet[0], new Capital(spreadSheet[1], Long.parseLong(spreadSheet[2].replace(",", "")), Double.parseDouble(spreadSheet[3])));
        }
    }

    public static void printHashMap(HashMap<String, Capital> stateCapital) {
        int nextLine = 0;
        Set<String> states = stateCapital.keySet();

        System.out.println("=====================================+");
        for (String state : states) {
            System.out.printf("%-16s %-20s|\n", "State: ", state);
            System.out.printf("%-16s %-20s|\n", "Capital: ", stateCapital.get(state).getCapitalName());
            System.out.printf("%-16s %-20s|\n", "Population: ", stateCapital.get(state).getPopulation());
            System.out.printf("%-16s %-20s|\n", "Square Mileage: ", stateCapital.get(state).getSqrtMileage() + " mi" + ((char) 178));
            System.out.println("=====================================+");
        }
    }

    public static HashMap<String, Capital> filterHashMap(HashMap<String, Capital> stateCapital, long filter) {
        HashMap<String, Capital> results = new HashMap<>();

        System.out.println("\nRecords that has population more than " + filter + " are: ");

        Set<String> states = stateCapital.keySet();
        for (String state : states) {
            if (stateCapital.get(state).getPopulation() > filter) {
                results.put(state, new Capital(stateCapital.get(state).getCapitalName(), stateCapital.get(state).getPopulation(), stateCapital.get(state).getSqrtMileage()));
            }
        }
        return results;
    }
}
