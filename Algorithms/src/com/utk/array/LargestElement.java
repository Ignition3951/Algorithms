package com.utk.array;

import com.utk.array.util.Utility;

import java.util.logging.Logger;

public class LargestElement {

    private static final Logger LOGGER = Logger.getLogger(LargestElement.class.getName());

    public static void main(String[] args) {
        int[] arr = {3, 3, 0, 99, -40};
        Utility.findLargestElement(arr);
    }
}
