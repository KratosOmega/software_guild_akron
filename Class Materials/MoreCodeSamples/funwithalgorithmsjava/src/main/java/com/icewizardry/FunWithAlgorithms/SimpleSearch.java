package com.icewizardry.FunWithAlgorithms;

/**
 * Created by vjpudelski on 8/9/16.
 */
public class SimpleSearch {
    public boolean Search(int[] items, int itemToFind){
        boolean isFound = false;

        for (int i = 0; i < items.length; i++){
            if (items[i] == itemToFind){
                isFound = true;
                break;
            }
        }

        return isFound;
    }
}
