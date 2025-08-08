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
        LOGGER.log(Level.INFO, "Array after rotation to the left : {0}", Arrays.toString(rotatedArray));
    }

    public static void moveZeroesToLast(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
        LOGGER.log(Level.INFO, "Array after moving zeroes to the last: {0}", Arrays.toString(nums));
    }

    public static int[] unionOfSortedArrays(int[] arr1, int[] arr2) {
        int size = arr1.length + arr2.length;
        int[] unionArray = new int[size];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {// 3,  4,  6,  7,  9, 9       1,  5,  7,  8,  8
            if (arr1[i] < arr2[j]) {
                if (k == 0 || unionArray[k - 1] != arr1[i]) {
                    unionArray[k++] = arr1[i];
                }
                i++;
            } else if (arr1[i] == arr2[j]) {
                if (k == 0 || unionArray[k - 1] != arr1[i]) {
                    unionArray[k++] = arr1[i];
                }
                i++;
                j++;
            } else {
                if (k == 0 || unionArray[k - 1] != arr2[j]) {
                    unionArray[k++] = arr2[j];
                }
                j++;
            }
        }
        while (i < arr1.length) {
            if (unionArray[k - 1] != arr1[i]) {
                unionArray[k++] = arr1[i];
            }
            i++;
        }
        while (j < arr2.length) {
            if (unionArray[k - 1] != arr2[j]) {
                unionArray[k++] = arr2[j];
            }
            j++;
        }
        int[] result = new int[k];
        for (int a = 0; a < k; a++) {
            result[a] = unionArray[a];
        }
        return result;
    }

    public static int findMissingNumber(int[] nums) {
        int size = nums.length+1;
        boolean[] numbersFound = new boolean[size];
        for (int num : nums) {
            numbersFound[num] = true;
        }
        for (int i = 0; i < size; i++) {
            if (!numbersFound[i]) {
                return i;
            }
        }
        return -1;
    }
}
