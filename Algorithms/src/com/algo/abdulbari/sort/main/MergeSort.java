package com.algo.abdulbari.sort.main;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MergeSort {

    private static final Logger LOGGER = Logger.getLogger(MergeSort.class.getName());

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr, 0, arr.length - 1);
        LOGGER.log(Level.INFO,"Sorted array : {}",Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int l, int h) {
        if (l < h) {
            int mid = (l + h) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, h);
            merge(arr, l, mid, h);
        }
    }

    public static void merge(int[] arr, int l, int mid, int h) {
        int n1 = mid - l + 1;
        int n2 = h - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[mid + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < n1) {
            arr[k++] = left[i++];
        }
        while (j < n2) {
            arr[k++] = right[j++];
        }
    }

}
