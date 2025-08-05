package com.utk.array;

import com.utk.array.util.Utility;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LargestElement {

    private static final Logger LOGGER = Logger.getLogger(LargestElement.class.getName());

    public static void main(String[] args) {
        int[] arr = {10, 10, 10, 10, 10};
        int n = 2;
        int nLargestElement = Utility.findLargestElement(arr, n);
        LOGGER.log(Level.INFO, "The {0} largest element in the array is: {1}", new Object[]{n, nLargestElement});
    }
}
