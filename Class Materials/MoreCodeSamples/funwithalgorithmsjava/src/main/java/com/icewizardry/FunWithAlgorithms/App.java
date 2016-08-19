package com.icewizardry.FunWithAlgorithms;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by vjpudelski on 8/9/16.
 */
public class App {
    public static void main(String[] args){
        SimpleSearch();
        BinarySearch();
        SelectionSort();
        QuickSort();
    }

    public static void SimpleSearch(){
        int[] items = new int[] {1,3,5,7,9,2,4,6,8};
        int itemToFind = 8;
        SimpleSearch scout = new SimpleSearch();
        boolean isFound = scout.Search(items, itemToFind);

        System.out.println("Simple Search for " + itemToFind);
        System.out.println(Arrays.toString(items));
        System.out.println(isFound);
        System.out.println();
    }

    public static void BinarySearch(){
        int[] items = new int[] {1,2,3,4,5,6,7,8,9};
        int itemToFind = 8;
        BinarySearch scout = new BinarySearch();
        boolean isFound = scout.Search(items, itemToFind);

        System.out.println("Bianry Search for " + itemToFind);
        System.out.println(Arrays.toString(items));
        System.out.println(isFound);
        System.out.println();
    }

    public static void SelectionSort(){
        int[] items = new int[] {7,3,6,2,9,1,8,5,4};

        SelectionSort sorter = new SelectionSort();

        System.out.println("Selection Sort");
        System.out.println(Arrays.toString(items));

        sorter.Sort(items);

        System.out.println(Arrays.toString(items));
        System.out.println();
    }

    public static void QuickSort(){
        int[] items = new int[] {3,1,4,5,2};

        QuickSort sorter = new QuickSort();

        System.out.println("Quick Sort");
        System.out.println(Arrays.toString(items));

        sorter.Sort(items, 0, 4);

        System.out.println(Arrays.toString(items));
        System.out.println();
    }
}
