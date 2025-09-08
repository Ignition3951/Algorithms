package com.utk.searching.util;


import java.util.List;

public class Utility {

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
        int difference;
        int counter = arr.length / 2;
        int forwardSum = arr[0];
        int reverseSum = 0;
        int forwardPointer = 2;
        int reversePointer = arr.length - 2;
        for (int i = 0; i < counter; i++) {
            forwardSum += arr[forwardPointer];
            reverseSum += arr[reversePointer];
            forwardPointer = forwardPointer + 2;
            reversePointer = reversePointer - 2;
        }
        difference = Math.abs(forwardSum - reverseSum);
        return difference;
    }
}
