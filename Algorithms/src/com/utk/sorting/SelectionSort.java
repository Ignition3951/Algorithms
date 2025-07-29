package com.utk.sorting;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SelectionSort {

    private static final Logger LOGGER = Logger.getLogger(SelectionSort.class.getName());

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr);
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int smallest = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[smallest] > arr[j]) {
                    smallest = j;
                }
            }
            swap(arr, i, smallest);
        }
        LOGGER.log(Level.INFO, "Selection sorted array : {0}", Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
