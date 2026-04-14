package com.utk.leetcode;

public class Problem907 {

    static void main() {
        int[] arr = new int[]{11,81,94,43,3};
        System.out.println(sumSubarrayMins(arr));
    }
    public static int sumSubarrayMins(int[] arr) {
        int total = 0;
        int min = Integer.MAX_VALUE;
        int m = 1000000007;
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
                min = Math.min(min, arr[j]);
                total += min % m;
            }
            min = Integer.MAX_VALUE;
        }
        return total;
    }
}
