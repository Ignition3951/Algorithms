package com.utk.leetcode;

public class Problem1004 {

    static void main() {
        int[] arr = {0, 0, 1, 1, 1, 0, 0};
        int k = 0;
        System.out.println(longestOnes(arr, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int result = 0;
        int left = 0;
        int right = 0;
        int zeroes = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroes++;
            }
            if (zeroes > k) {
                if (nums[left] == 0) zeroes--;
                left++;
            }
            if (zeroes <= k) {
                int length = right - left + 1;
                result = Math.max(length, result);
            }
            right++;
        }
        return result;
    }
}
