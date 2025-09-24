package com.utk.searching.util;

import java.util.Arrays;
import java.util.List;
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

        int[] searchOccurrence = {1, 3, 5};
        int searchOccTarget = 1;
        LOGGER.log(Level.INFO, "The number occurs on the index : {0}", Utility.searchRotatedArray(searchOccurrence, searchOccTarget));

        int[] findMin = {3, 4, 5, 1, 2};
        LOGGER.log(Level.INFO, "The minimum element is : {0}", Utility.findMin(findMin));

        List<Integer> findKRotation = Arrays.asList(4, 5, 1, 2);
        LOGGER.log(Level.INFO, "The list has been rotated {0} times.", Utility.findKRotation(findKRotation));

        int[] singleNonDuplicate = {3, 3, 7, 7, 10, 11, 11};
        LOGGER.log(Level.INFO, "The single element in the array is : {0}", Utility.singleNonDuplicate(singleNonDuplicate));

        int[] peakElement = {1, 2, 1, 3, 5, 6, 4};
        LOGGER.log(Level.INFO, "The peak element is at the index : {0}", Utility.findPeakElement(peakElement));

        long floorSqrt = 28;
        LOGGER.log(Level.INFO, "The floor value of sqrt of {0} is {1}", new Object[]{floorSqrt, Utility.floorSqrt(floorSqrt)});

        int N = 4;
        int M = 69;
        LOGGER.log(Level.INFO, "The value of Nth root is : {0}", Utility.findNthRoot(N, M));

        int[] bananaPile = {805306368, 805306368, 805306368};
        int hours = 1000000000;
        LOGGER.log(Level.INFO, "The minimum number of bananas koko needs to eat are : {0}", Utility.minEatingSpeed(bananaPile, hours));

        int[] bloomDay = {7, 7, 7, 7, 1, 7, 7};
        int bouquets = 1;
        int flowers = 1;
        LOGGER.log(Level.INFO, "The minimum number of days to create the bouquets required are : {0}", Utility.roseGarden(bloomDay, bouquets, flowers));

        int[] smallestDivisor = {21212, 10101, 12121};
        int threshold = 1000000;
        LOGGER.log(Level.INFO, "The smallesr divisor which satisfies the condition is : {0}", Utility.smallestDivisor(smallestDivisor, threshold));

        int[] weights = {1, 2, 3, 1, 1};
        int days = 4;
        LOGGER.log(Level.INFO, "The minimum capacity that the ship must have to transfer the weights in {0} days is : {1}", new Object[]{days, Utility.shipWithinDays(weights, days)});

        int[] kthPositive = {2, 3, 4, 7, 11};
        int k = 5;
        LOGGER.log(Level.INFO, "The missing {0}th positive number is : {1}", new Object[]{k, Utility.findKthPositive(kthPositive, k)});

        int[] stalls = {4, 2, 1, 3, 6};
        int aggressiveCows = 2;
        LOGGER.log(Level.INFO, "The minimum distance to place the cows in stalls is : {0}", Utility.aggressiveCows(stalls, aggressiveCows));

        int[] pages = {7, 2, 5, 10, 8};
        int students = 2;
        LOGGER.log(Level.INFO, "The minimum number of pages that can be distributed among the students are: {0}", Utility.findPages(pages, students));

        int[] gasArray = {1, 7};
        int gasStations = 2;
        LOGGER.log(Level.INFO, "The minimized gas station distance is : {0}", Utility.minMaxDistance(gasArray, gasStations));

        int[] num1 = {1,2};
        int[] num2 = {3,4};
        LOGGER.log(Level.INFO, "The median of the sorted array is : {0}", Utility.findMedianSortedArrays(num1, num2));
    }
}
