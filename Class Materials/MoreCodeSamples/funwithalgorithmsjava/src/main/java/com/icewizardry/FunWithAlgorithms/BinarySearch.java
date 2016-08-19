package com.icewizardry.FunWithAlgorithms;

/**
 * Created by vjpudelski on 8/9/16.
 */
public class BinarySearch {
    public boolean Search(int[] items, int itemToFind){
        boolean isFound = false;

        int low = 0;
        int high = items.length;

        while (low <= high){
            int mid = low + (high - low)/2;

            if (items[mid] == itemToFind){
                isFound = true;
                break;
            }
            else if (items[mid] < itemToFind){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return isFound;
    }
}
