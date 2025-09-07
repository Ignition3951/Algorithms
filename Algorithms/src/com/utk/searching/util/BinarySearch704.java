package com.utk.searching.util;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinarySearch704 {

    private static final Logger LOGGER = Logger.getLogger(BinarySearch704.class.getName());

    public static void main(String[] args) {
        int[] binarySearchArray = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        int binarySearchResult = Utility.binarySearch(binarySearchArray, target);
        LOGGER.log(Level.INFO, "The result of the binary search operation is : {0}", binarySearchResult);

        int[] lowerBound = {3, 5, 8, 15, 19};
        int lowerBoundTarget = 9;
        LOGGER.log(Level.INFO, "The lower bound for the array is :{0}", Utility.lowerBound(lowerBound, lowerBoundTarget));

        int[] searchInsert = {1, 3};
        int searchInsertTarget = 2;
        LOGGER.log(Level.INFO, "The search insert index is : {0}", Utility.searchInsert(searchInsert, searchInsertTarget));

        int[] floorCeil = {3, 4, 4, 7, 8, 10};
        int floorCeilTarget = 8;
        LOGGER.log(Level.INFO, "The floor and ceil of the array is : {0}", Arrays.toString(Utility.getFloorAndCeil(floorCeil, floorCeilTarget)));

        int[] searchRange = {2, 2};
        int searchTarget = 2;
        LOGGER.log(Level.INFO, "The starting and ending position are : {0}", Arrays.toString(Utility.searchRange(searchRange, searchTarget)));

        int[] countOccurrences = {2, 4, 6, 8, 10};
        int countTarget = 3;
        LOGGER.log(Level.INFO, "The number of occurrences in the array : {0}", Utility.countOccurrences(countOccurrences, countTarget));

        int[] searchOccurrence = {1,3,5};
        int searchOccTarget = 1;
        LOGGER.log(Level.INFO, "The number occurs on the index : {0}", Utility.searchRotatedArray(searchOccurrence, searchOccTarget));

    }
}
