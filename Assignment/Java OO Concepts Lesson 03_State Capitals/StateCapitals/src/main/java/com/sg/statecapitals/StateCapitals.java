/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Kratos
 */
public class StateCapitals {

    public static void main(String[] args) throws IOException {
        HashMap<String, String> stateCapitalHashMap = new HashMap<>();
        stateCapitalHashMap.put("Alabam", "Montgomery");
        stateCapitalHashMap.put("Alaska", "Juneau");
        stateCapitalHashMap.put("Arizona", "Phoenix");
        stateCapitalHashMap.put("Arkansas", "Little Rock");
        stateCapitalHashMap.put("California", "Sacramento");
        stateCapitalHashMap.put("Colorado", "Denver");
        stateCapitalHashMap.put("Connecticut", "Hartford");
        stateCapitalHashMap.put("Delaware", "Dover");
        stateCapitalHashMap.put("Florida", "Tallahassee");
        stateCapitalHashMap.put("Georgia", "Atlanta");
        stateCapitalHashMap.put("Hawaii", "Honolulu");
        stateCapitalHashMap.put("Idaho", "Boise");
        stateCapitalHashMap.put("Illinois", "Springfield");
        stateCapitalHashMap.put("Indiana", "Indianapolis");
        stateCapitalHashMap.put("Iowa", "Des Moines");
        stateCapitalHashMap.put("Kansas", "Topeka");
        stateCapitalHashMap.put("Kentucky", "Frankforta");
        stateCapitalHashMap.put("Louisiana", "Baton Rouge");
        stateCapitalHashMap.put("Maine", "Augusta");
        stateCapitalHashMap.put("Maryland", "Annapolis");
        stateCapitalHashMap.put("Massachusetts", "Boston");
        stateCapitalHashMap.put("Michigan", "Lansing");
        stateCapitalHashMap.put("Minnesota", "Saint Paul");
        stateCapitalHashMap.put("Mississippi", "Jackson");
        stateCapitalHashMap.put("Missouri", "Jefferson City");
        stateCapitalHashMap.put("Montana", "Helena");
        stateCapitalHashMap.put("Nebraska", "Lincoln");
        stateCapitalHashMap.put("Nevada", "Carson City");
        stateCapitalHashMap.put("New Hampshire", "Concord");
        stateCapitalHashMap.put("New Jersey", "Trenton");
        stateCapitalHashMap.put("New Mexico", "Santa Fe");
        stateCapitalHashMap.put("New York", "Albany");
        stateCapitalHashMap.put("North Carolina", "Raleigh");
        stateCapitalHashMap.put("North Dakota", "Bismarck");
        stateCapitalHashMap.put("Ohio", "Columbus");
        stateCapitalHashMap.put("Oklahoma", "Oklahoma City");
        stateCapitalHashMap.put("Oregon", "Salem");
        stateCapitalHashMap.put("Pennsylvania", "Harrisburg");
        stateCapitalHashMap.put("Rhode Island", "Providence");
        stateCapitalHashMap.put("South Carolina", "Columbia");
        stateCapitalHashMap.put("South Dakota", "Pierre");
        stateCapitalHashMap.put("Tennessee", "Nashville");
        stateCapitalHashMap.put("Texas", "Austin");
        stateCapitalHashMap.put("Utah", "Salt Lake City");
        stateCapitalHashMap.put("Vermont", "Montpelier");
        stateCapitalHashMap.put("Virginia", "Richmond");
        stateCapitalHashMap.put("Washington", "Olympia");
        stateCapitalHashMap.put("West Virginia", "Charleston");
        stateCapitalHashMap.put("Wisconsin", "Madison");
        stateCapitalHashMap.put("Wyoming", "Cheyenne");

        System.out.println("");
        String[] stateAsKey = new String[stateCapitalHashMap.size()];
        int index = 0;
        // keySet
        Set<String> states = stateCapitalHashMap.keySet();
        System.out.println("STATES:");
        System.out.println("=======");
        for (String state : states) {
            stateAsKey[index] = state;
            index++;
        }
        int repeat = stateCapitalHashMap.size();
        String temp;
        while (repeat > 1) {
            for (int i = 0; i < repeat - 1; i++) {
                if (stateAsKey[i].compareTo(stateAsKey[i + 1]) > 0) {
                    temp = stateAsKey[i];
                    stateAsKey[i] = stateAsKey[i + 1];
                    stateAsKey[i + 1] = temp;
                }
            }
            repeat--;
        }

        for (String state : stateAsKey) {
            System.out.println(state);
        }

        System.out.println("");

// valueSet
//        Collection<String> capitals = stateCapitalHashMap.values();
        System.out.println("CAPTIALS:");
        System.out.println("=========");
        for (String state : stateAsKey) {
            System.out.println(stateCapitalHashMap.get(state));
        }
        System.out.println("");

// pairs
        System.out.println("STATE/CAPITAL PAIRS:");
        System.out.println("====================");

        for (String state : stateAsKey) {
            System.out.println(state + " - " + stateCapitalHashMap.get(state));
        }
    }
}
