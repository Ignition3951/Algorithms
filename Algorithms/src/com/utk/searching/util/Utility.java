package com.utk.searching.util;


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
}
