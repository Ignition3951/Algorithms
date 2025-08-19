package com.utk.array.util;

import java.util.*;
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
        int size = nums.length + 1;
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

    public static int maximumConsecutiveOnes(int[] nums) {
        int counter = 0;
        int lastCount = 0;
        for (int number : nums) {//1,1,0,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1
            if (number == 1) {
                ++counter;
            } else {
                if (lastCount < counter) {
                    lastCount = counter;
                }
                counter = 0;
            }
        }
        return lastCount > counter ? lastCount : counter;
    }

    public static int singleNumber(int[] arr) {
        int XOR = 0;//same numbers when XOR return zero
        for (int i = 0; i < arr.length; i++) {
            XOR = XOR ^ arr[i]; // zero xor any number is the number itself
        }
        return XOR;
    }

    public static int longestSubArrayV1(int[] nums, int k) {
        int length = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int total = k;
            int j = i;
            while (total > 0 && j < nums.length) {
                total -= nums[j++];
                length++;
            }
            if (total == 0 && length > result) {
                result = length;
                length = 0;
            }
        }
        return result;
    }

    public static int longestSubArrayV2(int[] nums, int k) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0;
        int longestSubArrLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumMap.put(sum, i);
            if ((sum - k) >= 0 && sumMap.containsKey((sum - k))) {
                longestSubArrLength = Math.max(longestSubArrLength,
                        sumMap.get(sum) - sumMap.get(sum - k));
            }
        }
        return longestSubArrLength;
    }

    public static int longestSubArrayV3(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int sum = nums[0];
        int length = 0;
        while (i < nums.length && j < nums.length - 1) {
            if (sum > k) {
                sum -= nums[i++];
            } else if (sum < k) {
                sum += nums[++j];
            } else {
                length = Math.max(length, j - i + 1);
                sum += nums[++j];
            }

        }
        return length;
    }

    public static int[] twoSum(int[] nums, int target) {
        int counter = 0;
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();//1, 3, 5, -7, 6, -3
        for (int num : nums) {
            if (map.containsKey(target - num)) {
                result[0] = map.get(target - num);
                result[1] = counter;
                break;
            } else {
                map.put(num, counter++);
            }

        }
        return result;
    }

    public static void sortZeroOneTwo(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    public static void swap(int[] arr, int initialLocation, int finalLocation) {
        int temp = arr[finalLocation];
        arr[finalLocation] = arr[initialLocation];
        arr[initialLocation] = temp;
    }

    public static int majorityElement(int[] nums) {
        int counter = 0;
        int element = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (element == nums[i]) {
                counter++;
            } else {
                counter--;
            }
            if (counter == 0 && i < nums.length - 1) {
                element = nums[i + 1];
            }
        }
        return element;
    }

    public static int maxSubArraySum(int[] nums) {
        int sum = 0;
        int maximum = Integer.MIN_VALUE;
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (sum == 0)
                start = i;
            sum += nums[i];
            if (sum > maximum) {
                maximum = sum;
                end = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        LOGGER.log(Level.INFO, "The index of the largest sub array is from {0} to {1}", new Object[]{start, end});
        return maximum;
    }

    public static int maxProfit(int[] prices) {
        int minimum = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - minimum;
            profit = Math.max(profit, cost);
            minimum = Math.min(minimum, prices[i]);
        }
        return profit;
    }

    public static int[] rearrangeArray(int[] nums) {
        int[] rearrangedArray = new int[nums.length];
        int positiveCounter = 0;
        int negativeCounter = 1;
        for (int num : nums) {
            if (num > 0) {
                rearrangedArray[positiveCounter] = num;
                positiveCounter += 2;
            } else {
                rearrangedArray[negativeCounter] = num;
                negativeCounter += 2;
            }
        }
        return rearrangedArray;
    }

    public static void nextPermutation(int[] nums) {
        int breakpoint = -1;
        int reverseSize = 0;
        int counter = 0;
        int swapIndex = 0;
        int lowest = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                breakpoint = i - 1;
                break;
            }
            reverseSize++;
        }
        int[] reverseArray = new int[reverseSize + 1];
        if (breakpoint == -1) {
            for (int k = nums.length - 1; k > breakpoint; k--) {
                reverseArray[counter++] = nums[k];
            }
            counter = 0;
            for (int l = breakpoint + 1; l < nums.length; l++) {
                nums[l] = reverseArray[counter++];
            }
            return;
        }
        for (int j = breakpoint + 1; j < nums.length; j++) {
            if (nums[breakpoint] < nums[j] && nums[j] <= lowest) {
                lowest = nums[j];
                swapIndex = j;
            }
        }
        swap(nums, breakpoint, swapIndex);
        for (int k = nums.length - 1; k > breakpoint; k--) {
            reverseArray[counter++] = nums[k];
        }
        counter = 0;
        for (int l = breakpoint + 1; l < nums.length; l++) {
            nums[l] = reverseArray[counter++];
        }
    }

    public static List<Integer> leaders(int[] nums) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int maxElement = nums[nums.length - 1];
        leaders.addFirst(maxElement);
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= maxElement) {
                leaders.addFirst(nums[i]);
                maxElement = nums[i];
            }
        }
        return leaders;
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> numset = new HashSet<>();
        int maximumLength = 0;
        int counter = 1;
        for (int num : nums) {
            numset.add(num);
        }
        LOGGER.log(Level.INFO,"The hashset is : {0}",numset);
        for (int num : numset) {
            if(numset.contains(num-1)){
                continue;
            }
            while (numset.contains(++num)) {
                counter++;
            }
            maximumLength = Math.max(maximumLength, counter);
            counter=1;
        }
        return maximumLength;
    }
}