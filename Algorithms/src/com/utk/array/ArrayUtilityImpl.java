package com.utk.array;

import com.utk.array.util.Utility;

import java.util.Arrays;
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

        int[] removeDuplicatesFromSortedArray = {3, 4, 6, 7, 9, 9};
        int countOfUniqueElements = Utility.removeDuplicatesFromSortedArray(removeDuplicatesFromSortedArray);
        LOGGER.log(Level.INFO, " The count of unique elements in the sorted array is: {0}", countOfUniqueElements);

        int[] rotateArray = {3, 4, 1, 5, 3, -5};
        int d = 8;
        Utility.rotateArrayLeftByDSpaces(rotateArray, d);

        int[] moveZeroesToLast = {0, 20, 0, -20, 0, 20};
        Utility.moveZeroesToLast(moveZeroesToLast);

        int[] firstSortedArray = {3, 4, 6, 7, 9, 9};
        int[] secondSortedArray = {1, 5, 7, 8, 8};
        int[] unionSortedArray = Utility.unionOfSortedArrays(firstSortedArray, secondSortedArray);
        LOGGER.log(Level.INFO, "The union of arrays is : {0}", Arrays.toString(unionSortedArray));

        int[] findNumbers = {3, 0, 1};
        LOGGER.log(Level.INFO, "The missing number is : {0}", Utility.findMissingNumber(findNumbers));

        int[] maxConsOnes = {1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1};
        LOGGER.log(Level.INFO, "The maximum consecutive ones are : {0}", Utility.maximumConsecutiveOnes(maxConsOnes));

        int[] nums = {2,2,1};
        LOGGER.log(Level.INFO, "The single element in the array is : {0}", Utility.singleNumber(nums));
    }
}
