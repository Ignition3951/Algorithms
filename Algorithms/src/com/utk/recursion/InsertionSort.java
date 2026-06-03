package com.utk.recursion;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertionSort {

    private static final Logger LOGGER = Logger.getLogger(InsertionSort.class.getName());

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        insertionSort(arr, 1);
        LOGGER.log(Level.INFO, "Insertion sorted array : {0}", java.util.Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr, int size) {
        if (size <= arr.length - 1) {
            int element = arr[size];
            int count = size - 1;
            while (count >= 0 && element < arr[count]) {
                arr[count + 1] = arr[count--];
            }
            arr[count + 1] = element;
            insertionSort(arr, size + 1);
        }
    }
}
