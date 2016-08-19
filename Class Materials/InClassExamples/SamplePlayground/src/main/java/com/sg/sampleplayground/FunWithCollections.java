/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sampleplayground;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 *
 * @author softwareguild
 */
public class FunWithCollections {

    // tool
    // 1. make things better
    // 2. make things easier
    public static void main(String[] args) {
       // playWithDictionary();
       playWithArrayList();
    }

    public static void playWithDictionary() {
        HashMap<String, String[]> dictionary = new HashMap();
        String[] definitions = {
            "1. make things better",
            "2. make things easier"
        };
        dictionary.put("tool", definitions);

        definitions[0] = "1. be different";

        String[] definitions2 = {
            "1. be different"
        };
        dictionary.put("tool", definitions2);
        dictionary.put("unique", definitions2);

        System.out.println("dictionary contains tool? "
                + dictionary.containsKey("tool"));

        System.out.println(dictionary.get("tool"));

        System.out.println("The current map size is: " + dictionary.size());
        dictionary.remove("tool");
        System.out.println("The current map size is: " + dictionary.size());

        System.out.println(dictionary.toString());

        // entrySet
        System.out.println("Printing entries");
        System.out.println("==================");
        for (Entry e : dictionary.entrySet()) {
            System.out.println(e.getKey() + ":" + e.getValue());
            // loop through definitions
            String[] mapDefinitions = (String[]) e.getValue();
            for (String mapDefinition : mapDefinitions){
                System.out.println(mapDefinition);
            }
        }

        // keySet
        System.out.println("Printing keys");
        System.out.println("==================");
        for (String key : dictionary.keySet()) {
            System.out.println(key);
        }

        // values
        System.out.println("Printing values");
        System.out.println("==================");
        for (String[] value : dictionary.values()) {
            System.out.println(value);
        }

    }
    
    public static void playWithArrayList(){
        ArrayList<String> stringList = new ArrayList<String>();
        System.out.println("The list size is: " + stringList.size());
        
        // add an object to the list
        stringList.add("Gonzo");
        System.out.println("The list size is: " + stringList.size());
        
        stringList.add("Animal");
        stringList.add("Kermit");
        stringList.add("Rowlf");
        stringList.add("Rowlf");
        stringList.add("Statler");
        
        System.out.println("The list size is: " + stringList.size());
        
        System.out.println("Our Muppets are: ");
        for (String character : stringList){
            System.out.println(character);
        }
        
        boolean isRemoved = stringList.remove("Rowlf");
        
        for (int characterCount = 0; characterCount < stringList.size(); characterCount++){
            System.out.println(stringList.get(characterCount));
        }
        
        stringList.add(1, "Miss Piggy");
        
        boolean isMissPiggyRemoved = stringList.remove("Miss Piggy");

        System.out.println("The list size is: " + stringList.size());

        String removedString = stringList.remove(0);
        
        System.out.println("The list size is: " + stringList.size());

        Iterator<String> iter = stringList.iterator();
        
        while(iter.hasNext()){
            String currentCharacter = iter.next();
            System.out.println(currentCharacter);
        }
        
        iter = stringList.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}










