package com.utk.recursion;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReverseArray {

    private static final Logger LOGGER = Logger.getLogger(ReverseArray.class.getName());

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 23, 67, 89, 12, 56, 13, 5, 6, 7, 8, 9, 10, 11, 12};
        LOGGER.log(Level.INFO, "Reversed Array is : {0}", Arrays.toString(reverseArray(arr, 0, arr.length - 1)));
    }

    public static int[] reverseArray(int[] arr, int startIndex, int endIndex) {
        int temp;
        if (startIndex == 0) {
            temp = arr[0];
        } else {
            temp = arr[startIndex];
        }
        if (startIndex < endIndex) {
            temp = arr[startIndex];
            reverseArray(arr, startIndex + 1, endIndex);
        }
        arr[endIndex - startIndex] = temp;
        return arr;
    }
}
