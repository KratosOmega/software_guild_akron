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
public class SortDriver {

    public static void main(String[] args) {

        Integer[] nums = new Integer[5];
        nums[0] = 20;
        nums[1] = 2;
        nums[2] = 300;
        nums[3] = 0;
        nums[4] = -99;

        Sort.selectionSort(nums);
        for (Integer i : nums) {
            System.out.println(i);
        }

        nums[0] = 20;
        nums[1] = 2;
        nums[2] = 300;
        nums[3] = 0;
        nums[4] = -99;

        Sort.insertionSort(nums);
        for (Integer i : nums) {
            System.out.println(i);
        }
        
        String[] words = new String[5];
        words[0] = "zebra";
        words[1] = "quick";
        words[2] = "apple";
        words[3] = "apple1";
        words[4] = "apple2";
        
        Sort.selectionSort(words);
        
        for (String s : words) {
            System.out.println(s);
        }

    }
}
