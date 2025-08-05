package com.utk.array.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Utility {

    private static final Logger LOGGER = Logger.getLogger(Utility.class.getName());

    private Utility() {
        // Private constructor to prevent instantiation
    }

    public static int findLargestElement(int[] arr) {
        LOGGER.log(Level.INFO, "Inside findLargestElement method");
        int lowest = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                lowest = arr[i + 1];
            }
        }
        LOGGER.log(Level.INFO, "the largest number in the array is: {0}", lowest);
        return lowest;
    }
}
