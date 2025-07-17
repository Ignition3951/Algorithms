package com.algo.abdulbari.sort.main;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuickSort {

    private static final Logger LOGGER = Logger.getLogger(QuickSort.class.getName());

    public static void main(String[] args) {
        int[] arr = {10, 16, 8, 12, 15, 6, 3, 9, 5,34, 2, 1, 4, 7, 11, 13, 14, 17, 18, 19, 20};
        int[] sortedArray = Arrays.copyOf(arr, arr.length + 1);
        sortedArray[sortedArray.length - 1] = Integer.MAX_VALUE;
        LOGGER.log(Level.INFO,"Copied Array: {0}",Arrays.toString(sortedArray));
        quickSort(sortedArray, 0, sortedArray.length-1);
        LOGGER.log(Level.INFO,"Sorted Array: {0}",Arrays.toString(sortedArray));
    }

    private static void quickSort(int[] sortedArray, int left, int right) {
        if (left < right) {
            int partition = partition(sortedArray, left, right);
            quickSort(sortedArray, left, partition);
            quickSort(sortedArray, partition + 1, right);
        }
    }

    private static int partition(int[] sortedArray, int left, int right) {
        int i = 0;
        int j = right;
        int pivot = sortedArray[left];
        while (i < j) {
            while (sortedArray[i] > pivot) {
                i++;
            }
            while (sortedArray[j] < pivot) {
                j--;
            }
            if (i < j) {
                // Swap elements at i and j
                int temp = sortedArray[i];
                sortedArray[i] = sortedArray[j];
                sortedArray[j] = temp;
            }
        }
        return j;
    }
}
