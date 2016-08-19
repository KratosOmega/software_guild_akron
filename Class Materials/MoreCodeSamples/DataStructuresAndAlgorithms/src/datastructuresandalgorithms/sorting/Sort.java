/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresandalgorithms.sorting;

/**
 *
 * @author warde
 */
public abstract class Sort {
    
    public static void selectionSort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (Sort.isLess(arr[j], arr[minIndex])) {
                    minIndex = j;
                }
            }
            // put the smallest value at index i
            Sort.swap(arr, i, minIndex);
        }
    }
    
    public static void insertionSort(Comparable[] arr) {
        // start at 1 because the inner loop looks at i - 1
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && isLess(arr[j], arr[j-1]); j--) {
                swap(arr, j, j-1);
            }
        }
    }    
    
    private static boolean isLess(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    
    private static void swap(Comparable[] arr, int index1, int index2) {
        Comparable c = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = c;
    }
    
    private static boolean isSorted(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (isLess(arr[i], arr[i-1])) {
                // we found one element that is out of place
                return false;
            }
        }
        // all elements are in place
        return true;
    }
    
}
