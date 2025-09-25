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

    public static boolean searchMatrix240(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0) {
            if (matrix[row][column] == target) return true;
            if (matrix[row][column] < target) row++;
            else column--;
        }
        return false;
    }
}
