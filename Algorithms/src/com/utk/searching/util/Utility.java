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
}
