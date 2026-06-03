package com.utk.recursion;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BubbleSort {

    private static final Logger LOGGER = Logger.getLogger(BubbleSort.class.getName());

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        bubbleSort(arr, arr.length - 1);
        LOGGER.log(Level.INFO, "BUBBLE SORT AT PLAY : {0}", Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr, int size) {
        if (size >= 1) {
            for (int i = 0; i < size; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
            bubbleSort(arr, size - 1);
        }


    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
