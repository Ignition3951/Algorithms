package com.utk.sorting;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertionSort {

    private static final Logger LOGGER = Logger.getLogger(InsertionSort.class.getName());

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        insertionSort(arr);
        LOGGER.log(Level.INFO, "Insertion sorted array : {0}", java.util.Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j--];
            }
            arr[j + 1] = key;
        }
    }
}
