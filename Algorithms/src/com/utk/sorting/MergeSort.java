package com.utk.sorting;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MergeSort {

    private static final Logger LOGGER = Logger.getLogger(MergeSort.class.getName());

    public static void main(String[] args) {
        int[] arr = {7, 4, 1, 5, 3, 2, 6};
        mergeSort(arr, 0, arr.length - 1);
        LOGGER.log(Level.INFO, "Merge sorted array : {0}", java.util.Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, high, mid);
        }
    }

    public static void merge(int[] arr, int low, int high, int mid) {
        int leftSize = mid - low + 1;
        int rightSize = high - mid;
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];
        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = arr[low + i];
        }
        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = low;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }
        while (i < leftSize) {
            arr[k++] = leftArray[i++];
        }
        while (j < rightSize) {
            arr[k++] = rightArray[j++];
        }
    }
}
