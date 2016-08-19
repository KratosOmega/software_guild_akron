package com.icewizardry.FunWithAlgorithms;

/**
 * Created by parallels on 8/11/16.
 */
public class SelectionSort {
    public void Sort(int[] items){
        for (int i = 0; i < items.length - 1; i++){
            int min = i;

            for (int j = i+1; j < items.length; j++){
                if (items[j] < items[min]){
                    min = j;
                }
            }

            if (min != i) {
                int temp = items[i];
                items[i] = items[min];
                items[min] = temp;
            }
        }
    }
}
