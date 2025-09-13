package com.utk.searching.util;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utility {

    private static final Logger LOGGER = Logger.getLogger(Utility.class.getName());

    private Utility() {

    }

    public static int binarySearch(int[] arr, int target) {
        return binarySearchRecursive(arr, target, 0, arr.length - 1);
    }

    public static int binarySearchRecursive(int[] arr, int target, int low, int high) {
        int mid = (low + high) / 2;
        if (arr[mid] == target) return mid;
        if (low > high) return -1;
        if (arr[mid] < target) {
            binarySearchRecursive(arr, target, mid + 1, high);
        } else {
            binarySearchRecursive(arr, target, low, mid - 1);
        }
        return -1;
    }

    public static int lowerBound(int[] arr, int x) {
        int lowerBound = -1;
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] >= x) {
                lowerBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lowerBound;
    }

    public static int searchInsert(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        int result = arr.length;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] >= target) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static int[] getFloorAndCeil(int[] arr, int x) {
        int[] floorCeil = new int[2];
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) { // 3, 4, 4, 7, 8, 10              5
            mid = (low + high) / 2;
            if (arr[mid] == x) {
                floorCeil[0] = arr[mid];
                floorCeil[1] = arr[mid];
                return floorCeil;
            } else if (arr[mid] > x) {
                floorCeil[0] = arr[high - 1];
                floorCeil[1] = arr[high];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return floorCeil;
    }

    public static int[] searchRange(int[] arr, int target) {
        int[] range = new int[2];
        int lowerBound;
        int upperBound = -1;
        lowerBound = firstOccurrence(arr, target);
        if (lowerBound != -1) {
            upperBound = lastOccurrence(arr, target);
        }
        range[0] = lowerBound;
        range[1] = upperBound;
        return range;
    }

    private static int lastOccurrence(int[] arr, int target) {
        int upperBound = -1;
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == target) {
                upperBound = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return upperBound;
    }

    private static int firstOccurrence(int[] arr, int target) {
        int lowerBound = -1;
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == target) {
                lowerBound = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return lowerBound;
    }

    public static int countOccurrences(int[] arr, int target) {
        int occurrences = -1;
        int firstOccurrence = firstOccurrence(arr, target);
        int lastOccurrence;
        if (firstOccurrence != -1) {
            lastOccurrence = lastOccurrence(arr, target);
            occurrences = lastOccurrence - firstOccurrence + 1;
        }
        return occurrences;
    }

    public static int searchRotatedArray(int[] arr, int target) {
        int index = -1;
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == target) return mid;
            //check if left array is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return index;
    }

    public static int findMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        if (arr.length == 1) return arr[0];
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[low] <= arr[high] && arr[low] < arr[mid]) {
                high = mid - 1;
            } else if (arr[low] > arr[high] && arr[high] < arr[mid]) {
                low = mid + 1;
            } else {
                low++;
                high--;
            }
        }
        LOGGER.log(Level.INFO, "The minimum is : {0}", arr[mid]);
        return arr[mid];
    }

    public static int findKRotation(List<Integer> arr) {
        int rotations = 0;
        int first = 0;
        int last = arr.size() - 1;
        while (first <= last) {
            if (arr.get(first) >= arr.get(last)) {
                rotations++;
                first++;
                last--;
            } else {
                break;
            }
        }
        return rotations;
    }

    public static int singleNonDuplicate(int[] arr) {
        if (arr.length == 1) return arr[0];
        if (arr[0] != arr[1]) return arr[0];
        if (arr[arr.length - 2] != arr[arr.length - 1]) return arr[arr.length - 1];
        int low = 1;
        int high = arr.length - 2;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) return arr[mid];
            if ((mid % 2 == 1 && arr[mid - 1] == arr[mid]) || (mid % 2 == 0 && arr[mid + 1] == arr[mid])) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static int findPeakElement(int[] arr) {
        if (arr.length == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[arr.length - 1] > arr[arr.length - 2]) return arr.length - 1;
        int low = 1;
        int high = arr.length - 2;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            if (arr[mid] > arr[mid - 1])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static long floorSqrt(long n) {
        long low = 1;
        long high = n;
        long mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if ((mid * mid) <= n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static int findNthRoot(int N, int M) {//N=3 M=27
        int low = 1;
        int high = M;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (Math.pow(mid, N) == M) return mid;
            if (Math.pow(mid, N) > M) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    public static int minEatingSpeed(int[] arr, int h) {
        int minHours;
        int high = findMaxElement(arr);
        int low = 1;
        int mid;
        int result = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            minHours = calculateHours(arr, mid);
            if (minHours < 0) return result;
            if (minHours <= h) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int findMaxElement(int[] arr) {
        int maxElement = 0;
        for (int num : arr) {
            maxElement = Math.max(maxElement, num);
        }
        return maxElement;
    }

    public static int calculateHours(int[] arr, int numberOfBananas) {
        int hoursRequired = 0;
        for (int num : arr) {
            hoursRequired += Math.ceilDiv(num, numberOfBananas);
        }
        return hoursRequired;
    }

    public static int roseGarden(int[] arr, int m, int k) {
        boolean isBouquetPossible;//m=bouquet(2) k=flowers(3)
        int result = Integer.MAX_VALUE;
        int high = findMaxElement(arr);
        int low = findMin(arr);
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            isBouquetPossible = countAdjacentFlowers(arr, mid, k, m);
            if (isBouquetPossible) {
                result = Math.min(result, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static boolean countAdjacentFlowers(int[] arr, int mid, int k, int m) {
        int result = 0;
        int bouquets = 0;
        for (int flower : arr) {
            if (mid >= flower) {
                result++;
                if (result % k == 0) ++bouquets;
            } else {
                result = 0;
            }
        }
        LOGGER.log(Level.INFO, "The bouquets that can be made on day {0} are {1}", new Object[]{mid, bouquets});
        return bouquets >= m;
    }

    public static int smallestDivisor(int[] arr, int threshold) {
        int result = Integer.MAX_VALUE;
        int[] minAndMax = findMinAndMaxInArray(arr);
        int low = 1;
        int high = Math.max(minAndMax[1], threshold);
        int mid;
        boolean isLessThanThreshold;
        while (low <= high) {
            mid = (low + high) / 2;
            isLessThanThreshold = compareSumFromThreshold(arr, mid, threshold);
            if (isLessThanThreshold) {
                result = Math.min(result, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static int[] findMinAndMaxInArray(int[] arr) {
        int[] minAndMax = new int[2];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int number : arr) {
            min = Math.min(min, number);
            max = Math.max(max, number);
        }
        minAndMax[0] = min;
        minAndMax[1] = max;
        return minAndMax;
    }

    public static boolean compareSumFromThreshold(int[] arr, int divisor, int threshold) {
        boolean result = false;
        int sum = 0;
        for (int number : arr) {
            sum += (int) Math.ceil((double) number / (double) divisor);
        }
        if (sum <= threshold) {
            result = true;
        }
        return result;
    }
}
