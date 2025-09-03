package com.utk.searching.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BinarySearch704 {

    private static final Logger LOGGER = Logger.getLogger(BinarySearch704.class.getName());

    public static void main(String[] args) {
        int[] binarySearchArray = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        int binarySearchResult = Utility.binarySearch(binarySearchArray, target);
        LOGGER.log(Level.INFO, "The result of the binary search operation is : {0}", binarySearchResult);
    }
}
