package com.utk.searching.util;


public class Utility {

    private Utility() {

    }

    public static int binarySearch(int[] arr, int target) {
        int result = -1;
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {

            mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static boolean searchMatrix240(int[][] matrix,int target){
        int result;
        for (int[] ints : matrix) {
            result = binarySearch(ints, target);
            if (result != -1) return true;
        }
        return false;
    }
}
