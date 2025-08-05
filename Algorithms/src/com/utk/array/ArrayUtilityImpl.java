package com.utk.array;

import com.utk.array.util.Utility;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ArrayUtilityImpl {

    private static final Logger LOGGER = Logger.getLogger(ArrayUtilityImpl.class.getName());

    public static void main(String[] args) {
        int[] arr = {10, 10, 10, 10, 10};
        int n = 2;
        int nLargestElement = Utility.findFirstOrSecondLargestElement(arr, n);
        LOGGER.log(Level.INFO, "The {0} largest element in the array is: {1}", new Object[]{n, nLargestElement});

        int[] checkIfSortedArray = {1, 2, 1, 4, 5};
        boolean isSorted = Utility.isSortedArray(checkIfSortedArray);
        LOGGER.log(Level.INFO, "Is the array sorted? {0}", isSorted);

        int[] removeDuplicatesFromSortedArray = {0, 0, 3, 3, 5, 6};
        int countOfUniqueElements = Utility.removeDuplicatesFromSortedArray(removeDuplicatesFromSortedArray);
        LOGGER.log(Level.INFO, " The count of unique elements in the sorted array is: {0}", countOfUniqueElements);
    }
}
