package com.utk.array;

import com.utk.array.util.Utility;

import java.util.Arrays;
import java.util.List;
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

        int[] nums = {2, 2, 1};
        LOGGER.log(Level.INFO, "The single element in the array is : {0}", Utility.singleNumber(nums));

        int[] longestSubArray = {-3, 2, 1};
        int k = 6;
        LOGGER.log(Level.INFO, "The size of the longest sub-array is : {0}", Utility.longestSubArrayV3(longestSubArray, k));

        int[] twoSum = {1, 3, 5, -7, 6, -3};
        int target = 0;
        LOGGER.log(Level.INFO, "The indices corresponding to sum are : {0}", Arrays.toString(Utility.twoSum(twoSum, target)));

        int[] zeroOneTwo = {1, 0, 2, 1, 0};
        Utility.sortZeroOneTwo(zeroOneTwo);
        LOGGER.log(Level.INFO, "The sorted array is : {0}", Arrays.toString(zeroOneTwo));

        int[] maxElementArr = {7, 0, 0, 1, 7, 7, 2, 7, 7};
        LOGGER.log(Level.INFO, "The majority element in the array is : {0}", Utility.majorityElement(maxElementArr));

        int[] maxSubArraySum = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        LOGGER.log(Level.INFO, "The sum of maximum sub array is : {0}", Utility.maxSubArraySum(maxSubArraySum));

        int[] profit = {10, 7, 5, 8, 11, 9};
        LOGGER.log(Level.INFO, "The maximum profit that can be earned is : {0}", Utility.maxProfit(profit));

        int[] rearrangeArray = {1, -1, -3, -4, 2, 3};
        LOGGER.log(Level.INFO, "The rearranged array is : {0}", Arrays.toString(Utility.rearrangeArray(rearrangeArray)));

        int[] nextPermutation = {2, 3, 1, 3, 3};
        Utility.nextPermutation(nextPermutation);
        LOGGER.log(Level.INFO, "The next permutation is : {0}", Arrays.toString(nextPermutation));

        int[] leaders = {-3, 4, 5, 1, -4, -5};
        LOGGER.log(Level.INFO, "The leaders array is : {0}", Utility.leaders(leaders));

        int[] longestConsecutive = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        LOGGER.log(Level.INFO, "The longest consecutive sequence is : {0}", Utility.longestConsecutive(longestConsecutive));

        int[][] matrix2d = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        LOGGER.log(Level.INFO, "The before zeroes array is : {0}", Arrays.deepToString(matrix2d));
        Utility.setZeroes(matrix2d);
        LOGGER.log(Level.INFO, "The zeroes array is : {0}", Arrays.deepToString(matrix2d));

        int[][] rotate = {{1, 2}, {3, 4}};
        Utility.rotate(rotate);
        LOGGER.log(Level.INFO, "The 90 degree rotated array is : {0}", Arrays.deepToString(rotate));

        int[][] spiral = {{7}, {9}, {6}};
        LOGGER.log(Level.INFO, "The spiral list is : {0}", Utility.spiralOrder(spiral));

        int[] masterArray = {-1, -1, 1};
        int sum = 0;
        LOGGER.log(Level.INFO, "The number of sub arrays having sum as {0} are {1}", new Object[]{sum, Utility.subArraySum(masterArray, sum)});

        int rows = 5;
        Utility.generatePascalTriangle(rows);

        int[] majorityElementTwo = {2, 1, 1, 3, 1, 4, 5, 6};
        LOGGER.log(Level.INFO, "The majority element two list is: {0}", Utility.majorityElementTwo(majorityElementTwo));

        int[] threeSumArray = {-2, -2, -2, -1, -1, -1, 0, 0, 0, 2, 2, 2, 2};
        LOGGER.log(Level.INFO, "The list of triplets is : {0}", Utility.threeSum(threeSumArray).toString());

        int[] fourSumArray = {1000000000, 1000000000, 1000000000, 1000000000};
        int fourTarget = -294967296;
        LOGGER.log(Level.INFO, "The list of quadruplets is : {0}", Utility.fourSum(fourSumArray, fourTarget).toString());

        int[] maxSubArraySumZero = {2, 10, 4};
        LOGGER.log(Level.INFO, "The longest sub array with sum zero is : {0}", Utility.maxLenSubArray(maxSubArraySumZero));

        int[][] overlappingIntervals = {{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}};//{{1, 5}, {3, 6}, {8, 10}, {15, 18}};//[4,5],[1,4],[0,1]
        LOGGER.log(Level.INFO, "The overlapping array is : {0}", Arrays.deepToString(Utility.mergeOverlap(overlappingIntervals)));

        int[] sorted1 = {0};//{1, 2, 3, 0, 0, 0};
        int m = 0;
        int[] sorted2 = {1};//{2, 5, 6};
        int o = 1;
        Utility.merge(sorted1, m, sorted2, o);
    }
}
