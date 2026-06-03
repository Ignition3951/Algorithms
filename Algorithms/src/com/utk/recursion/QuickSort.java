package com.utk.recursion;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuickSort {

    private static final Logger LOGGER = Logger.getLogger(QuickSort.class.getName());

    public static void main(String[] args) {
        int[] arr = {5, 4, 4, 1, 1};
        int[] sortedArr = Arrays.copyOf(arr, arr.length + 1);
        sortedArr[sortedArr.length - 1] = Integer.MAX_VALUE;
        quickSort(sortedArr, 0, sortedArr.length - 1);
        LOGGER.log(Level.INFO, "Quick sorted array : {0}", java.util.Arrays.toString(sortedArr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);
            quickSort(arr, low, partition);
            quickSort(arr, partition + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int lowest = low;
        int highest = high;
        while (lowest < highest) {
            do {
                lowest++;
            } while (lowest <= arr.length - 1 && arr[lowest] > pivot);
            do {
                highest--;
            } while (highest >= 0 && arr[highest] < pivot);
            if (lowest < highest) {
                swap(arr, lowest, highest);
            }
        }
        swap(arr, low, highest);
        return highest;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
