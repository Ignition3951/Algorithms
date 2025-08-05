package com.utk.array.util;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utility {

    private static final Logger LOGGER = Logger.getLogger(Utility.class.getName());

    private Utility() {
        // Private constructor to prevent instantiation
    }

    public static int findFirstOrSecondLargestElement(int[] arr, int n) {
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

    public static boolean isSortedArray(int[] arr) {
        int counter = 1;
        int firstSortedElement = arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] >= firstSortedElement) {
                counter++;
                firstSortedElement = arr[i];
            } else {
                break;
            }
        }
        LOGGER.log(Level.INFO, "The value of counter is {0}", counter);
        return (counter == arr.length - 1);
    }

    public static int removeDuplicatesFromSortedArray(int[] nums) {
        int uniqueIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                nums[++uniqueIndex] = nums[i];
            }
        }
        LOGGER.log(Level.INFO, "The unique array is: {0}", Arrays.toString(nums));
        return uniqueIndex + 1;
    }

    public static void rotateArrayLeftByDSpaces(int[] nums, int d) {
        int[] rotatedArray = new int[nums.length];
        if (d > nums.length) {
            d = d % nums.length; // Handle cases where d is greater than the array length
        }
        for (int i = 0; i < nums.length; i++) {
            if ((i - d) >= 0) {
                rotatedArray[i - d] = nums[i];
            } else {
                rotatedArray[nums.length - (d - i)] = nums[i];
            }
        }
        LOGGER.log(Level.INFO, "Array after rotation: {0}", Arrays.toString(rotatedArray));
    }
}
