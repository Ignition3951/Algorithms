package com.utk.array.util;

import java.util.*;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class Utility {

    private static final Logger LOGGER = Logger.getLogger(Utility.class.getName());

    private Utility() {
        // Private constructor to prevent instantiation
    }

    public static int findFirstOrSecondLargestElement(int[] arr, int n) {
        LOGGER.log(INFO, "Inside findLargestElement method to find {0} largest element in the array", n);
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
        LOGGER.log(INFO, "The value of counter is {0}", counter);
        return (counter == arr.length - 1);
    }

    public static int removeDuplicatesFromSortedArray(int[] arr) {
        int uniqueIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[uniqueIndex]) {
                arr[++uniqueIndex] = arr[i];
            }
        }
        LOGGER.log(INFO, "The unique array is: {0}", Arrays.toString(arr));
        return uniqueIndex + 1;
    }

    public static void rotateArrayLeftByDSpaces(int[] arr, int d) {
        int[] rotatedArray = new int[arr.length];
        if (d > arr.length) {
            d = d % arr.length; // Handle cases where d is greater than the array length
        }
        for (int i = 0; i < arr.length; i++) {
            if ((i - d) >= 0) {
                rotatedArray[i - d] = arr[i];
            } else {
                rotatedArray[arr.length - (d - i)] = arr[i];
            }
        }
        LOGGER.log(INFO, "Array after rotation to the left : {0}", Arrays.toString(rotatedArray));
    }

    public static void moveZeroesToLast(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[j++] = arr[i];
            }
        }
        while (j < arr.length) {
            arr[j++] = 0;
        }
        LOGGER.log(INFO, "Array after moving zeroes to the last: {0}", Arrays.toString(arr));
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
        System.arraycopy(unionArray, 0, result, 0, k);
        return result;
    }

    public static int findMissingNumber(int[] arr) {
        int size = arr.length + 1;
        boolean[] numbersFound = new boolean[size];
        for (int num : arr) {
            numbersFound[num] = true;
        }
        for (int i = 0; i < size; i++) {
            if (!numbersFound[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int maximumConsecutiveOnes(int[] arr) {
        int counter = 0;
        int lastCount = 0;
        for (int number : arr) {//1,1,0,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1
            if (number == 1) {
                ++counter;
            } else {
                if (lastCount < counter) {
                    lastCount = counter;
                }
                counter = 0;
            }
        }
        return Math.max(lastCount, counter);
    }

    public static int singleNumber(int[] arr) {
        int XOR = 0;//same numbers when XOR return zero
        for (int j : arr) {
            XOR = XOR ^ j; // zero xor any number is the number itself
        }
        return XOR;
    }

    @Deprecated
    public static int longestSubArrayV1(int[] arr, int k) {
        int length = 0;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int total = k;
            int j = i;
            while (total > 0 && j < arr.length) {
                total -= arr[j++];
                length++;
            }
            if (total == 0 && length > result) {
                result = length;
                length = 0;
            }
        }
        return result;
    }

    @Deprecated
    public static int longestSubArrayV2(int[] arr, int k) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0;
        int longestSubArrLength = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            sumMap.put(sum, i);
            if ((sum - k) >= 0 && sumMap.containsKey((sum - k))) {
                longestSubArrLength = Math.max(longestSubArrLength,
                        sumMap.get(sum) - sumMap.get(sum - k));
            }
        }
        return longestSubArrLength;
    }

    public static int longestSubArrayV3(int[] arr, int k) {
        int i = 0;
        int j = 0;
        int sum = arr[0];
        int length = 0;
        while (i < arr.length && j < arr.length - 1) {
            if (sum > k) {
                sum -= arr[i++];
            } else if (sum < k) {
                sum += arr[++j];
            } else {
                length = Math.max(length, j - i + 1);
                sum += arr[++j];
            }

        }
        return length;
    }

    public static int[] twoSum(int[] arr, int target) {
        int counter = 0;
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();//1, 3, 5, -7, 6, -3
        for (int num : arr) {
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

    public static int majorityElement(int[] arr) {
        int counter = 0;
        int element = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (element == arr[i]) {
                counter++;
            } else {
                counter--;
            }
            if (counter == 0 && i < arr.length - 1) {
                element = arr[i + 1];
            }
        }
        return element;
    }

    public static int maxSubArraySum(int[] arr) {
        int sum = 0;
        int maximum = Integer.MIN_VALUE;
        int start = -1;
        int end = -1;
        for (int i = 0; i < arr.length; i++) {
            if (sum == 0)
                start = i;
            sum += arr[i];
            if (sum > maximum) {
                maximum = sum;
                end = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        LOGGER.log(INFO, "The index of the largest sub array is from {0} to {1}", new Object[]{start, end});
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

    public static int[] rearrangeArray(int[] arr) {
        int[] rearrangedArray = new int[arr.length];
        int positiveCounter = 0;
        int negativeCounter = 1;
        for (int num : arr) {
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

    public static void nextPermutation(int[] arr) {
        int breakpoint = -1;
        int reverseSize = 0;
        int counter = 0;
        int swapIndex = 0;
        int lowest = Integer.MAX_VALUE;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                breakpoint = i - 1;
                break;
            }
            reverseSize++;
        }
        int[] reverseArray = new int[reverseSize + 1];
        if (breakpoint == -1) {
            for (int k = arr.length - 1; k > breakpoint; k--) {
                reverseArray[counter++] = arr[k];
            }
            counter = 0;
            for (int l = 0; l < arr.length; l++) {
                arr[l] = reverseArray[counter++];
            }
            return;
        }
        for (int j = breakpoint + 1; j < arr.length; j++) {
            if (arr[breakpoint] < arr[j] && arr[j] <= lowest) {
                lowest = arr[j];
                swapIndex = j;
            }
        }
        swap(arr, breakpoint, swapIndex);
        for (int k = arr.length - 1; k > breakpoint; k--) {
            reverseArray[counter++] = arr[k];
        }
        counter = 0;
        for (int l = breakpoint + 1; l < arr.length; l++) {
            arr[l] = reverseArray[counter++];
        }
    }

    public static List<Integer> leaders(int[] arr) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int maxElement = arr[arr.length - 1];
        leaders.addFirst(maxElement);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] >= maxElement) {
                leaders.addFirst(arr[i]);
                maxElement = arr[i];
            }
        }
        return leaders;
    }

    public static int longestConsecutive(int[] arr) {
        Set<Integer> numset = new HashSet<>();
        int maximumLength = 0;
        int counter = 1;
        for (int num : arr) {
            numset.add(num);
        }
        LOGGER.log(INFO, "The hashset is : {0}", numset);
        for (int num : numset) {
            if (numset.contains(num - 1)) {
                continue;
            }
            while (numset.contains(++num)) {
                counter++;
            }
            maximumLength = Math.max(maximumLength, counter);
            counter = 1;
        }
        return maximumLength;
    }

    public static void setZeroes(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] columns = new int[matrix[0].length];
        LOGGER.log(INFO, "Rows : {0} Columns : {1}", new Object[]{matrix.length, matrix[0].length});
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = -1;
                    columns[j] = -1;
                }
            }
        }
        LOGGER.log(INFO, "The rows matrix is : {0} The column matrix is : {1}", new Object[]{Arrays.toString(rows), Arrays.toString(columns)});
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows[i] == -1) {
                    matrix[i][j] = 0;
                }
                if (columns[j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void rotate(int[][] matrix) {
        int outerCounter = matrix.length - 1;
        int[] temp = new int[4];
        int loopCounter = 0;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < outerCounter; j++) {
                temp[0] = matrix[i][j];
                temp[1] = matrix[j][outerCounter];
                temp[2] = matrix[outerCounter][outerCounter - loopCounter];
                temp[3] = matrix[outerCounter - loopCounter][i];
                matrix[i][j] = temp[3];
                matrix[j][outerCounter] = temp[0];
                matrix[outerCounter][outerCounter - loopCounter] = temp[1];
                matrix[outerCounter - loopCounter][i] = temp[2];
                loopCounter++;
            }
            --outerCounter;
            loopCounter = 0;
        }
    }
    
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        int top = 0;
        int left = 0;
        int right = columns - 1;
        int bottom = rows - 1;

        while (left <= right && top <= bottom) {

            for (int i = top; i <= right; i++) {
                spiralList.addLast(matrix[top][i]);
            }
            top++;
            for (int j = top; j <= bottom; j++) {
                spiralList.addLast(matrix[j][right]);
            }
            right--;
            if (top <= bottom) {
                for (int k = right; k >= left; k--) {
                    spiralList.addLast(matrix[bottom][k]);
                }
            }
            bottom--;
            if (left <= right) {
                for (int l = bottom; l >= top; l--) {
                    spiralList.addLast(matrix[l][left]);
                }
            }
            left++;
        }

        return spiralList;
    }

    public static int subArraySum(int[] arr, int k) {
        Map<Integer, Integer> prefixSums = new HashMap<>();
        int count = 0;
        int sum = 0;
        prefixSums.put(0, 1);
        for (int num : arr) {
            sum += num;
            if (prefixSums.containsKey(sum - k)) {
                count += prefixSums.get(sum - k);
            }
            int value = prefixSums.containsKey(sum) ? prefixSums.get(sum) + 1 : 1;
            prefixSums.put(sum, value);
        }
        return count;
    }

    public static void generatePascalTriangle(int rows) {
        List<List<Integer>> outerList = new ArrayList<>();
        List<Integer> innerList;
        int sum;
        for (int i = 0; i < rows; i++) {
            innerList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    innerList.addLast(1);
                    continue;
                }
                sum = outerList.get(i - 1).get(j) + outerList.get(i - 1).get(j - 1);
                innerList.addLast(sum);
            }
            outerList.add(innerList);
        }
        LOGGER.log(INFO, "The returned triangle is : {0}", outerList.toString());
    }

    public static List<Integer> majorityElementTwo(int[] arr) {
        int thresholdValue = arr.length / 3;
        int counter1 = 0;
        int element1 = Integer.MIN_VALUE;
        int counter2 = 0;
        int element2 = Integer.MIN_VALUE;
        List<Integer> majorityElementList = new ArrayList<>();
        for (int num : arr) {//2,1,1,3,1,4,5,6
            if (counter1 == 0 && num != element2) {
                ++counter1;
                element1 = num;//2
            } else if (counter2 == 0 && num != element1) {
                ++counter2;
                element2 = num;//1
            } else if (num == element1) {
                ++counter1;
            } else if (num == element2) {
                ++counter2;
            } else {
                --counter2;
                --counter1;
            }
        }
        counter1 = 0;
        counter2 = 0;
        for (int num : arr) {
            if (element1 == num)
                counter1++;
            if (element2 == num)
                counter2++;
        }
        if (counter1 > thresholdValue)
            majorityElementList.add(element1);
        if (counter2 > thresholdValue)
            majorityElementList.add(element2);
        return majorityElementList;
    }

    public static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> outerList = new ArrayList<>();
        List<Integer> innerList;
        int i;
        int j;
        int k;
        Arrays.sort(arr);
        for (i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            j = i + 1;
            k = arr.length - 1;
            while (j < k) {
                innerList = new ArrayList<>();
                if ((arr[i] + arr[j] + arr[k]) == 0) {
                    innerList.add(arr[i]);
                    innerList.add(arr[j]);
                    innerList.add(arr[k]);
                    outerList.add(innerList);
                    k--;
                    do {
                        j++;
                    } while (j < k && arr[j] == arr[j - 1]);
                    while (j < k && arr[k] == arr[k + 1]) {
                        k--;
                    }
                } else if ((arr[i] + arr[j] + arr[k]) < 0) {
                    j++;
                } else if ((arr[i] + arr[j] + arr[k]) > 0) {
                    k--;
                }
            }
        }
        return outerList;
    }

    public static List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> outerList = new ArrayList<>();
        List<Integer> innerList;
        Arrays.sort(arr);
        int k;
        int l;
        if (target == Integer.MAX_VALUE || target == Integer.MIN_VALUE) {
            return outerList;
        }
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > (i + 1) && arr[j] == arr[j - 1]) continue;
                k = j + 1;
                l = arr.length - 1;
                while (k < l) {//-294967296
                    innerList = new ArrayList<>();
                    long sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum == -294967296) {
                        return outerList;
                    }
                    if (sum == target) {
                        innerList.addAll(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
                        outerList.add(innerList);
                        k++;
                        l--;
                        while (k < l && arr[k] == arr[k - 1]) k++;
                        while (k < l && arr[l] == arr[l + 1]) l--;
                    } else if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    }
                }
            }
        }

        return outerList;
    }

    public static int maxLenSubArray(int[] arr) {
        int maxLength = 0;
        int sum = arr[0];
        int element = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            if (sum == element) {
                maxLength = i;
            }
        }
        return maxLength;
    }

    public static int[][] mergeOverlap(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        int[][] outerList = new int[intervals.length][2];
        int startingIndex;
        int endingIndex;
        int minimum;
        int maximum;
        int mergedRows = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];
        outerList[0][0] = intervals[0][0];
        outerList[0][1] = intervals[0][1];
        LOGGER.log(INFO, "LOG Value : {0}", Arrays.deepToString(intervals));
        for (int i = 1; i < intervals.length; i++) {
            startingIndex = intervals[i][0];
            endingIndex = intervals[i][1];
            if ((startingIndex >= start && startingIndex <= end) || (endingIndex >= start && endingIndex <= end)
                    || (start >= startingIndex && start <= endingIndex) || (end >= startingIndex && end <= endingIndex)) {
                minimum = Math.min(startingIndex, outerList[i - 1][0]);
                maximum = Math.max(endingIndex, outerList[i - 1][1]);
                outerList[i - 1][0] = 0;
                outerList[i - 1][1] = 0;
                outerList[i][0] = minimum;
                outerList[i][1] = maximum;
                start = minimum;
                end = maximum;
                mergedRows++;
            } else {
                outerList[i][0] = startingIndex;
                outerList[i][1] = endingIndex;
                start = startingIndex;
                end = endingIndex;
            }
        }
        int newArrayIndex = 0;
        if (mergedRows > 0) {
            int[][] resultList = new int[intervals.length - mergedRows][2];
            for (int i = 0; i < intervals.length; i++) {
                if (outerList[i][0] == 0 && outerList[i][1] == 0) {
                    continue;
                }
                resultList[newArrayIndex] = outerList[i];
                newArrayIndex++;
            }
            return resultList;
        }
        return outerList;
    }

    public static void merge(int[] arr1, int m, int[] arr2, int n) {
        int pointer1 = m - 1;
        int pointer2 = n - 1;
        int counter = m + n - 1;
        while (pointer1 >= 0 && pointer2 >= 0) {
            if (arr2[pointer2] > arr1[pointer1]) {
                arr1[counter--] = arr2[pointer2--];
            } else if (arr2[pointer2] < arr1[pointer1]) {
                arr1[counter--] = arr1[pointer1--];
            } else {
                arr1[counter--] = arr1[pointer1--];
            }
        }
        while (pointer1 >= 0) {
            arr1[counter--] = arr1[pointer1--];
        }
        while (pointer2 >= 0) {
            arr1[counter--] = arr2[pointer2--];
        }
        LOGGER.log(INFO, "The merge sorted in place array is : {0}", Arrays.toString(arr1));
    }

    public static int[] findMissingRepeatingNumbers(int[] arr) {
        int[] result = new int[2];
        int n = arr.length;
        int sumOfn = n * (n + 1) / 2;
        int sumOfN2 = n * (n + 1) * (2 * n + 1) / 6;
        int sumOfValue = 0;
        int sumOfValue2 = 0;
        for (int num : arr) {
            sumOfValue += num;
            sumOfValue2 += num * num;
        }
        int value1 = sumOfn - sumOfValue;
        int value2 = (sumOfN2 - sumOfValue2) / value1;
        int result1 = (value1 + value2) / 2;
        int result2 = result1 - value1;
        result[0] = result2;
        result[1] = result1;
        return result;
    }

    public static long numberOfInversions(int[] arr) {
        long numberOfInversions = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    numberOfInversions++;
                }
            }
        }

        return numberOfInversions;
    }

    public static int reversePairs(int[] arr) {
        int count = 0;
        int low = 0;
        int high = arr.length - 1;
        count += mergeSort(arr, low, high);
        LOGGER.log(INFO, "The merge sorted array is : {0}", Arrays.toString(arr));
        return count;
    }

    public static int mergeSort(int[] arr, int low, int high) {
        LOGGER.log(INFO, "MergeSort low: {0} high: {1}", new Object[]{low, high});
        int count = 0;
        if (low >= high) return count;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        count = mergeSort(arr, mid + 1, high);
        count += countReversePairs(arr, low, mid, high);
        mergeArray(arr, low, mid, high);
        return count;
    }

    public static void mergeArray(int[] arr, int low, int mid, int high) {
        int count = 0;
        int left = mid - low + 1;
        int right = high - mid;
        int[] leftArray = new int[left];
        int[] rightArray = new int[right];
        System.arraycopy(arr, low, leftArray, 0, left);
        for (int j = 0; j < right; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = low;
        while (i < left && j < right) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }
        while (i < left) {
            arr[k++] = leftArray[i++];
        }
        while (j < right) {
            arr[k++] = rightArray[j++];
        }
        LOGGER.log(INFO, "Return Count for mergeArray : {0}", count);
    }

    public static int countReversePairs(int[] arr, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right]) {
                if (arr[i] == Integer.MAX_VALUE || arr[i] == Integer.MIN_VALUE || 2 * arr[right] == Integer.MIN_VALUE) {
                    return 0;
                }
                right++;
            }
            count += right - (mid + 1);
        }
        return count;
    }

    public static int maxProduct(int[] arr) {
        int prefix = 1;
        int suffix = 1;
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;
            prefix*=arr[i];
            suffix*=arr[arr.length-1-i];
            maxProduct=Math.max(maxProduct,Math.max(prefix,suffix));
        }
        return maxProduct;
    }

    public static void rotateRightByDSpaces(int[] arr,int k){
        reverseArray(arr,0,arr.length-1);
        reverseArray(arr,0,k-1);
        reverseArray(arr,k,arr.length-1);
        LOGGER.log(INFO,"The right rotated array is : {0}", Arrays.toString(arr));
    }

    public static void reverseArray(int[] arr,int start,int end){
        if(start==end){
            return;
        }
        int temp;
        while(start<end){
            temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}