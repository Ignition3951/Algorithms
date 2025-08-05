package com.utk.array.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Utility {

    private static final Logger LOGGER = Logger.getLogger(Utility.class.getName());

    private Utility() {
        // Private constructor to prevent instantiation
    }

    public static int findLargestElement(int[] arr, int n) {
        LOGGER.log(Level.INFO, "Inside findLargestElement method to find {0} largest element in the array", n);
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {//8, 8, 7, 6, 5
            if (arr[i] > largest) {
                largest = arr[i];
            }
            if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        if (n == 1) {
            return largest == Integer.MIN_VALUE ? -1 : largest;
        } else {
            return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
        }
    }
}
