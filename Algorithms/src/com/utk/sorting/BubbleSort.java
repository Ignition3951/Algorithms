package com.utk.sorting;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BubbleSort {

    private static final Logger LOGGER = Logger.getLogger(BubbleSort.class.getName());

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        bubbleSort(arr);
        LOGGER.log(Level.INFO,"BUBBLE SORT AT PLAY : {0}", Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        for (int j = 0; j < arr.length - 1; j++) {
            boolean swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
