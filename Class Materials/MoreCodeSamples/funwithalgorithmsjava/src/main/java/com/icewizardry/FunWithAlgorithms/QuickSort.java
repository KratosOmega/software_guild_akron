package com.icewizardry.FunWithAlgorithms;

import java.util.Arrays;

/**
 * Created by parallels on 8/11/16.
 */
public class QuickSort {
    public void Sort(int[] items, int low, int high){
        if (items == null || items.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = items[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (items[i] < pivot) {
                i++;
            }

            while (items[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = items[i];
                items[i] = items[j];
                items[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            Sort(items, low, j);

        if (high > i)
            Sort(items, i, high);
    }
}
