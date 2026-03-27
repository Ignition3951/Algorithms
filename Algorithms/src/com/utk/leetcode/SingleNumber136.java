package com.utk.leetcode;

public class SingleNumber136 {

    static void main() {
        int[] nums = new int[]{1};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
